package com.jsg.controller;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Module;
import com.jsg.service.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * @author jeanson 进生
 * @date 2019/10/8 18:36
 */
@RestController
@RequestMapping("/permission")
@Api(value = "/permission", tags = "查询权限列表")
@Slf4j
public class PermissionController {

/*

    @Autowired
    private PermissionService permissionService;


    @ApiOperation(value = "系统管理-权限管理-查询所有模块以及模块下所有的权限", notes = "返回所有的属性列表数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", dataType = "int", required = false)})
    @PostMapping(value = "/findAll", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase findPermissionAll(Integer userId) throws Exception {
        return permissionService.findPermissionAll(userId);
    }
*/

}
