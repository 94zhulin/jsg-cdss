package com.jsg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import com.jsg.dao.mysql.ModuleMapper;
import com.jsg.dao.mysql.ModulePermissionMapper;
import com.jsg.dao.mysql.PermissionMapper;
import com.jsg.dao.mysql.RolePermissionMapper;
import com.jsg.entity.Module;
import com.jsg.entity.ModulePermission;
import com.jsg.entity.Pageable;
import com.jsg.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
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

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

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
        Module module = new Module();
        module.setChildren(list);
        module.setCode("QB");
        module.setName("全部");
        module.setId(0);
        module.setIdStr(0);
        module.setLabel("全部");
        module.setStatus(1);
        module.setLevel(1);
        module.setOrderIndex(0);
        List<Module> listNew = new ArrayList<>();
        listNew.add(module);
        PageInfo<Module> pageInfo = new PageInfo<>(listNew);
        return ResultUtil.success(null, pageInfo);
    }

    @Override
    public ResultBase search(String queryKey, Integer moduleId, Integer status, Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<Module> list = moduleMapper.search(queryKey, moduleId, status);
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
            if (permissionsid > 0) {
                ModulePermission roleP = new ModulePermission();
                roleP.setPermissionId(permissionsid);
                roleP.setModuleId(moduleId);
                lists.add(roleP);
            }

        });
        if (lists.size() > 0) {
            modulePermissionMapper.addBatch(lists);
            //更新Module表中roleId的权限数
            Module module = new Module();
            module.setId(moduleId);
            module.setPermissionNum(permissions.size());
            moduleMapper.edi(module);
        } else {
            modulePermissionMapper.del(moduleId);
        }
        return ResultUtil.success(null, permissions);

    }

    @Override
    public ResultBase navigationBar(Integer roleid) {
        //循环删除
        List<Module> list = moduleMapper.list(0);
        //获取用户权限
        List<Integer> userModuleIds = rolePermissionMapper.selectByPermission(roleid);
        if (userModuleIds.size() == 0) {
            return ResultUtil.success("暂无权限,请联系管理员 ", null);
        } else {
            boolean contains = userModuleIds.contains(4);
            if (!contains) {
                userModuleIds.add(4);
            }
        }
        int size = list.size();
        for (int i = size - 1; i >= 0; i--) {
            Module module = list.get(i);
            module.setPermissions(null);
            List<Module> childrens = module.getChildren();
            if (childrens.size() > 0) {
                int schildrenSize = childrens.size();
                for (int x = schildrenSize - 1; x >= 0; x--) {
                    Module moduleOdl = childrens.get(x);
                    moduleOdl.setPermissions(null);
                    Integer id = moduleOdl.getId();
                    if (!userModuleIds.contains(id)) {
                        childrens.remove(x);
                    }
                }
            }

            Integer id = module.getId();
            if (!userModuleIds.contains(id)) {
                list.remove(i);
            } else {
                @NotNull(message = "type is notnull") String code = module.getCode();
                if ("FM_XTGL".equals(code)) {
                    List<Module> children = module.getChildren();
                    if (children.size() == 0) {
                        list.remove(i);

                    }
                }
            }
        }
        return ResultUtil.success("", list);
    }
}
