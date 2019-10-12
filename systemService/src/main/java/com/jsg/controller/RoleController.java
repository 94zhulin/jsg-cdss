package com.jsg.controller;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Pageable;
import com.jsg.entity.Role;
import com.jsg.service.RoleService;
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
@RequestMapping("/role")
@Api(value = "/role", tags = "角色管理")
@Slf4j
public class RoleController {

    @Autowired
    private RoleService roleService;


    @ApiOperation(value = "添加角色", notes = "角色")
    @PostMapping(value = "/add", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase add(@RequestBody @Validated Role role) {
        return roleService.add(role);
    }


    @ApiOperation(value = "检索角色列表", notes = "可检索的角色列表接口")
    @ApiImplicitParam(name = "queryKey", value = "编码/名称", dataType = "string")
    @PostMapping(value = "/list", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase list(String queryKey, Pageable pageable) {
        return roleService.list(queryKey, pageable);
    }


    @ApiOperation(value = "删除角色", notes = "模块id删除角色")
    @ApiImplicitParam(name = "roleId", value = "角色ID", dataType = "int")
    @PostMapping(value = "/del", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase del(Integer roleId) {
        return roleService.del(roleId);
    }

    @ApiOperation(value = "编辑角色", notes = "系统管理-角色管理-编辑角色")
    @PostMapping(value = "/edi", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase edi(@RequestBody Role role) {
        return roleService.edi(role);
    }

    @ApiOperation(value = "查看用户", notes = "系统管理-角色管理-查询指定角色下的用户")
    @ApiImplicitParams({@ApiImplicitParam(name = "roleId", value = "角色ID", dataType = "int"),
            @ApiImplicitParam(name = "queryKey", value = "编码/名称", dataType = "string")
    })
    @PostMapping(value = "/list-user", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase listByUser(String queryKey, Integer roleId, Pageable pageable) {
        return roleService.listByUser(queryKey, roleId, pageable);
    }


    @ApiOperation(value = "分配权限", notes = "系统管理-角色管理-给角色分配权限")
    @PostMapping(value = "/distribution-permissions/{roleId}", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase distributionPermissions(@PathVariable("roleId") Integer roleId, @RequestParam(value = "permissions") List<Integer> permissions) {
        return roleService.distributionPermissions(roleId, permissions);
    }


    @ApiOperation(value = "角色拥有的权限", notes = "角色拥有的权限")
    @ApiImplicitParams({@ApiImplicitParam(name = "roleId", value = "角色ID", dataType = "int"),
    })
    @PostMapping(value = "/permissions/{roleId}", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultBase permissions(@PathVariable("roleId") Integer roleId) {
        return roleService.permissions(roleId);
    }


}
