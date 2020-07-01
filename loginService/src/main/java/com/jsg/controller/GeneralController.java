package com.jsg.controller;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.UserGenera;
import com.jsg.service.GeneralService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * generla
 * @author jeanson 进生
 * @date 2019/10/21 10:12
*/
@RestController
@RequestMapping("/login")
@Api(value = "/login", tags = "通用的小接口")
@Slf4j
public class GeneralController {

    @Autowired
    private GeneralService generalService;

    @ApiOperation(value = "用户登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "登录名", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String")
    })
    @PostMapping(value = "/login")
    public ResultBase login(String userName, String password) {
        log.info("functionName:{}    Url:{}  parameter:{} ", "用户登陆", "/login", userName, password);
        return generalService.login(userName, password);
    }

    @ApiOperation(value = "修改用户密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", dataType = "int"),
            @ApiImplicitParam(name = "odlPassword", value = "旧密码", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String")
    })
    @PostMapping(value = "/edl/password", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase edlPassword(Integer userId, String password, String odlPassword) {
        log.info("functionName:{}    Url:{}  parameter:{} ", "修改用户密码", "/edl/password", userId, password, odlPassword);
        return generalService.edlPassword(userId, password, odlPassword);
    }

    @ApiOperation(value = "添加用户)")
    @PostMapping(value = "/add", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase add(@RequestBody @Validated UserGenera user) {
        return generalService.add(user);
    }

    @ApiOperation(value = "根据id查询用户)")
    @ApiImplicitParam(name = "userId", value = "用户id", dataType = "int")
    @PostMapping(value = "/find/user", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase findUser(Integer userId) {
        return generalService.findUser(userId);
    }

}
