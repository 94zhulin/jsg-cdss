package com.jsg.controller;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Module;
import com.jsg.entity.Pageable;
import com.jsg.service.ModuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * @author jeanson 进生
 * @date 2019/10/8 18:36
 */
@RestController
@RequestMapping("/modele")
@Api(value = "/modele", tags = "模块管理")
@Slf4j
public class ModuleController {

    @Autowired
    private ModuleService moduleService;


    @ApiOperation(value = "添加功能模块", notes = "系统管理-模块管理-添加功能模块")
    @PostMapping(value = "/add", consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase add(@RequestBody @Validated Module module) {
        return moduleService.add(module);
    }


    @ApiOperation(value = "功能模块列表", notes = "系统管理-模块管理-分页查询功能模块")
    @PostMapping(value = "/list", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase list(Pageable pageable) {
        return moduleService.list(pageable);
    }


    @ApiOperation(value = "检索模块列表", notes = "可检索的模块列表接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "queryKey", value = "编码/名称", dataType = "string"),
            @ApiImplicitParam(name = "moduleId", value = "模块ID/root目录为0", dataType = "int"),
            @ApiImplicitParam(name = "status", value = "是否启用", dataType = "int"),
    })
    @PostMapping(value = "/search", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase list(String queryKey, Integer moduleId, Integer status, Pageable pageable) {
        return moduleService.search(queryKey, moduleId, status, pageable);
    }


    @ApiOperation(value = "删除模块", notes = "模块id删除模块")
    @ApiImplicitParam(name = "moduleId", value = "模块ID", dataType = "int")
    @PostMapping(value = "/del", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase del(Integer moduleId) {
        return moduleService.del(moduleId);
    }

    @ApiOperation(value = "编辑模块", notes = "系统管理-模块管理-编辑模块")
    @PostMapping(value = "/edi", consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase edi(@RequestBody Module module) {
        return moduleService.edi(module);
    }


    @ApiOperation(value = "模板拥有的权限", notes = "模板拥有的权限")
    @PostMapping(value = "/permissions/{moduleId}", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase permissions(@PathVariable("moduleId") Integer roleId) {
        return moduleService.permissions(roleId);
    }


    @ApiOperation(value = "分配权限", notes = "系统管理-模块管理-给模块分配权限")
    @PostMapping(value = "/distribution-permissions/{moduleId}", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase distributionPermissions(@PathVariable("moduleId") Integer moduleId, @RequestParam(value = "permissionGeneras") List<Integer> permissions) {
        return moduleService.distributionPermissions(moduleId, permissions);
    }

}
