package com.jsg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import com.jsg.dao.mysql.ModuleMapper;
import com.jsg.dao.mysql.ModulePermissionMapper;
import com.jsg.dao.mysql.PermissionMapper;
import com.jsg.entity.Module;
import com.jsg.entity.ModulePermission;
import com.jsg.entity.Pageable;
import com.jsg.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/9 15:40
 */
@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModuleMapper moduleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private ModulePermissionMapper modulePermissionMapper;

    @Value("${apiStatus.failure}")
    private Integer failure;

    @Value("${apiStatus.exc}")
    private Integer exc;

    @Value("${apiStatus.success}")
    private Integer success;


    @Override
    public ResultBase add(Module module) {
        List<Module> list = moduleMapper.selectByCodeOrUrl(module);
        ResultBase resultBase = ResultUtil.success(null, null);
        if (list.size() > 0) {
            resultBase.setStatus(failure);
            resultBase.setMsg("编码或URL重复");
        } else {
            moduleMapper.add(module);
            resultBase.setData(module);
        }
        return resultBase;
    }

    @Override
    public ResultBase list(Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<Module> list = moduleMapper.list(0);
        PageInfo<Module> pageInfo = new PageInfo<>(list);
        return ResultUtil.success(null, pageInfo);
    }

    @Override
    public ResultBase search(String queryKey, Integer moduleId, Integer status, Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<Module> list = moduleMapper.search(queryKey, moduleId,status);
        PageInfo<Module> pageInfo = new PageInfo<>(list);
        return ResultUtil.success(null, pageInfo);
    }

    @Override
    public ResultBase del(Integer moduleId) {
        int opFlag = moduleMapper.del(moduleId);
        modulePermissionMapper.del(moduleId);
        return ResultUtil.success(null, opFlag);
    }

    @Override
    public ResultBase edi(Module module) {
        List<Module> list = moduleMapper.selectByCodeOrUrl(module);
        ResultBase resultBase = ResultUtil.success(null, list);
        if (list.size() > 1) {
            resultBase.setStatus(failure);
            resultBase.setMsg("编码或URL重复");
        } else {
            moduleMapper.edi(module);
            resultBase.setData(module);
        }
        return resultBase;
    }

    @Override
    public ResultBase permissions(Integer moduleId) {
        return ResultUtil.success(null, permissionMapper.selectModulePermissions(moduleId));

    }

    @Override
    public ResultBase distributionPermissions(Integer moduleId, List<Integer> permissions) {
        modulePermissionMapper.del(moduleId);
        //批量添加到数据库中
        List<ModulePermission> lists = new ArrayList<>();
        permissions.forEach(permissionsid -> {
            ModulePermission roleP = new ModulePermission();
            roleP.setPermissionId(permissionsid);
            roleP.setModuleId(moduleId);
            lists.add(roleP);
        });
        modulePermissionMapper.addBatch(lists);
        //更新Module表中roleId的权限数
        Module module = new Module();
        module.setId(moduleId);
        module.setPermissionNum(permissions.size());
        moduleMapper.edi(module);
        return ResultUtil.success(null, permissions);

    }
}
