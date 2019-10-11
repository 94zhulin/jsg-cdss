package com.jsg.controller;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Pageable;
import com.jsg.entity.User;
import com.jsg.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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
 * @author jeanson 进生
 * @date 2019/10/8 18:36
 */
@RestController
@RequestMapping("/user")
@Api(value = "/user", tags = "用户管理模块")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "添加用户")
    @PostMapping(value = "/add", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase add(@RequestBody @Validated User user) {
        return userService.add(user);
    }


    @ApiOperation(value = "检索用户列表")
    @ApiImplicitParam(name = "queryKey", value = "编码/名称", dataType = "string")
    @PostMapping(value = "/list", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase list(String queryKey, Pageable pageable) {
        return userService.list(queryKey, pageable);
    }


    @ApiOperation(value = "删除用户")
    @ApiImplicitParam(name = "userId", value = "用户id", dataType = "int")
    @PostMapping(value = "/del", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase del(Integer userId) {
        return userService.del(userId);
    }

    @ApiOperation(value = "编辑用户/用户授权")
    @PostMapping(value = "/edi", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase edi(@RequestBody User user) {
        return userService.edi(user);
    }

}
