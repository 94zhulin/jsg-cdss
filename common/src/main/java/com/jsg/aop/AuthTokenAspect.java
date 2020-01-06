package com.jsg.aop;

import com.alibaba.fastjson.JSONArray;
import com.jsg.exce.CustomException;
import com.jsg.exce.ResultStatusEnum;
import com.jsg.utils.redis.RedisService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Aspect
@Component
public class AuthTokenAspect {
    @Autowired
    RedisService redisService;


    /**
     * Spring中使用@Pointcut注解来定义方法切入点
     *
     * @Pointcut 用来定义切点，针对方法  @Aspect 用来定义切面，针对类
     * 后面的增强均是围绕此切入点来完成的
     * 此处仅配置被我们刚才定义的注解：AuthToken修饰的方法即可
     */
    @Pointcut("@annotation(authToken)")
    public void doAuthToken(AuthToken authToken) {
    }

    /**
     * 此处我使用环绕增强，在方法执行之前或者执行之后均会执行。
     */
    @Around("doAuthToken(authToken)")
    public Object deBefore(ProceedingJoinPoint pjp, AuthToken authToken) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Cookie[] cookies = request.getCookies();
        String token = "";
        boolean flag = false;
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if ("JSESSIONID".equals(name)) {
                token = cookie.getValue();
                break;
            }
        }
        System.out.println("---------TOKEN-------------" + token);
        List<Object> permissions = redisService.lGet(token, 0, 500);
        String methodValue = authToken.value();
        for (Object obj : permissions) {
            JSONArray jurisdiction = (JSONArray) obj;
            for (Object code : jurisdiction) {
                String codeStr = code.toString();
                if (methodValue.equals(codeStr)) {
                    flag = true;
                    break;
                }
            }

        }
        if (!flag) {
            throw new CustomException(ResultStatusEnum.ABNORMAL_PERMISSIONS);
        }
        // 执行原方法，并记录返回值。
        Object proceed = pjp.proceed();
        System.out.println("---------方法执行之后-------------" + authToken);
        return proceed;
    }

}