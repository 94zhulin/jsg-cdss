package com.jsg.controller;

import com.jsg.service.UserService;
import com.jsg.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者：zhuLin
 * 日期：2020-06-24 11:57:57
 * 备注：用户控制器类
 */
@Api(tags = "用户模块")
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private StrUtil strUtil;

    @GetMapping("/getUser")
    public String  getUser () {
        return "---------------------";
    }


}
