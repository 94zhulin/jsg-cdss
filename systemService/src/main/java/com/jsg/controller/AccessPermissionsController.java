package com.jsg.controller;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.AccessAuth;
import com.jsg.entity.Pageable;
import com.jsg.service.AccessPermissionsService;
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
 * @author jeanson 进生
 * @date 2019/10/8 18:36
 */
@RestController
@RequestMapping("/access-permissions")
@Api(value = "/access-permissions", tags = "访问权限")
@Slf4j
public class AccessPermissionsController {


    @Autowired
    private AccessPermissionsService accessPermissionsService;

    @ApiOperation(value = "添加应用")
    @PostMapping(value = "/add", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase add(@RequestBody @Validated AccessAuth accessAuth) {
        return accessPermissionsService.add(accessAuth);
    }

    @ApiOperation(value = "检索应用列表")
    @ApiImplicitParams({

            @ApiImplicitParam(name = "queryKey", value = "检索关键词", dataType = "string"),
            @ApiImplicitParam(name = "status", value = "是否启用(0-已停用；1-已启用)", dataType = "int")
    })

    @PostMapping(value = "/list", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase list(String queryKey, Integer status, Pageable pageable) {
        return accessPermissionsService.list(queryKey, status, pageable);
    }

    @ApiOperation(value = "删除应用")
    @ApiImplicitParam(name = "accessAuthId", value = "应用id", dataType = "int")
    @PostMapping(value = "/del", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase del(Integer accessAuthId) {
        return accessPermissionsService.del(accessAuthId);
    }

    @ApiOperation(value = "编辑应用")
    @PostMapping(value = "/edi", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase edi(@RequestBody AccessAuth accessAuth) {
        return accessPermissionsService.edi(accessAuth);
    }


}
