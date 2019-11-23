package com.jsg.aop;

import com.jsg.exce.CustomException;
import com.jsg.exce.ResultStatusEnum;
import com.jsg.utils.redis.RedisService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Asepct
 *
 * @Description: datasource
 * @EnglishName LuKe
 * @authod LiuQi
 * @date 2019/6/27 18:23
 */
@Aspect
@Component
@Order(1)
public class PermissionCheckAsepct {

    @Autowired
    RedisService redisService;

    //
    @Pointcut("@annotation(com.jsg.aop.PermissionCheck)")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Object target = joinPoint.getTarget();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String token = "";
        String permission = "";
        String methodName = "";
        boolean flag = false;
        try {
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("Cookie".equals(name)) {
                    token = cookie.getValue();
                    break;
                }
            }
            Method method = target.getClass().getMethod(signature.getName(), signature.getParameterTypes());
            methodName = method.getName();
            if (method.isAnnotationPresent(PermissionCheck.class)) {
                PermissionCheck annotation = method.getAnnotation(PermissionCheck.class);
                permission = annotation.value();
                List<Object> permissions = redisService.lGet(token, 0, 500);
                for (Object obj : permissions) {
                    if (permission.equals(obj)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    throw new CustomException(ResultStatusEnum.ABNORMAL_PERMISSIONS);
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        //实现aop校验
        System.out.println("aop校验 methodName :" + methodName + "  PermissionName: " + permission + " token: " + token);
    }


}
