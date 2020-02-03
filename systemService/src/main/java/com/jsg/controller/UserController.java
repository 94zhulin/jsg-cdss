package com.jsg.controller;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Pageable;
import com.jsg.entity.User;
import com.jsg.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    // @AuthToken("XTGL_USER_ADD")
    @PostMapping(value = "/add", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase add(@RequestBody @Validated User user) {
        return userService.add(user);
    }


    @ApiOperation(value = "检索用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "queryKey", value = "编码/名称", dataType = "string"),
            @ApiImplicitParam(name = "status", value = "是否启用", dataType = "int")
    }
    )
    // @AuthToken("XTGL_USER_VIEW")
    @PostMapping(value = "/list", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase list(String queryKey, Integer status, Pageable pageable) {
        return userService.list(queryKey, status, pageable);
    }


    @ApiOperation(value = "删除用户")
    @ApiImplicitParam(name = "userId", value = "用户id", dataType = "int")
    // @AuthToken("XTGL_USER_DELETE")
    @PostMapping(value = "/del", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase del(Integer userId) {
        return userService.del(userId);
    }

    @ApiOperation(value = "编辑用户/")
    // @AuthToken("XTGL_USER_EDIT")
    @PostMapping(value = "/edi", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase edi(@RequestBody User user) {
        return userService.edi(user);
    }


    @ApiOperation(value = "用户授权")
    // @AuthToken("XTGL_USER_EDIT")
    @PostMapping(value = "/authorization/{id}/{roleId}", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase authorization(@PathVariable("id") Integer id, @PathVariable("roleId") Integer roleId) {
        return userService.authorization(id, roleId);
    }

}
