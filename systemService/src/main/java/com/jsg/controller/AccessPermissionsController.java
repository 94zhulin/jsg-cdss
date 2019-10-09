package com.jsg.controller;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * @author jeanson 进生
 * @date 2019/10/8 18:36
 */
@RestController
@RequestMapping("/access-permissions")
@Api(value = "/access-permissions", tags = "访问权限模块")
@Slf4j
public class AccessPermissionsController {


    @ApiOperation(value = "测试接口", notes = "自定义请求头sessionId，sessionId的值是登陆接口返回的")
    @PostMapping(value = "/test", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResultBase test(@RequestBody @Validated User users) {
        ResultBase resultBase = new ResultBase();
        resultBase.setStatus(1);
        User user = new User();
        user.setAge(15);
        user.setKsCode("1111");
        user.setMobileNum("13266890407");
        resultBase.setData(user);
        resultBase.setMsg("成功!");
        return resultBase;
    }

}
