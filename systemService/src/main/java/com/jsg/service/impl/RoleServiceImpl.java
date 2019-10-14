package com.jsg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import com.jsg.dao.mysql.PermissionMapper;
import com.jsg.dao.mysql.RoleMapper;
import com.jsg.dao.mysql.RolePermissionMapper;
import com.jsg.dao.mysql.UserMapper;
import com.jsg.entity.Pageable;
import com.jsg.entity.Role;
import com.jsg.entity.RolePermission;
import com.jsg.entity.User;
import com.jsg.service.RoleService;
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
public class RoleServiceImpl implements RoleService {


    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Value("${apiStatus.failure}")
    private Integer failure;

    @Value("${apiStatus.exc}")
    private Integer exc;

    @Value("${apiStatus.success}")
    private Integer success;

    @Override
    public ResultBase add(Role role) {
        List<Role> list = roleMapper.search(role);
        ResultBase resultBase = ResultUtil.success(null, role);
        if (list.size() > 0) {
            resultBase.setStatus(failure);
            resultBase.setMsg("名称或者编码已存在");
        } else {
            int insert = roleMapper.add(role);
        }
        return resultBase;
    }

    @Override
    public ResultBase list(String queryKey, Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<Role> list = roleMapper.list(queryKey);
        PageInfo<Role> pageInfo = new PageInfo<>(list);
        return ResultUtil.success(null, pageInfo);
    }

    @Override
    public ResultBase del(Integer roleId) {
        List<User> list = userMapper.selectUserByRoleId(null, roleId);
        ResultBase resultBase = ResultUtil.success(null, null);
        if (list.size() > 0) {
            resultBase.setStatus(failure);
            resultBase.setMsg("该角色有用户关联，不能直接删除");
        } else {
            roleMapper.del(roleId);
            rolePermissionMapper.del(roleId);
        }
        return resultBase;
    }

    @Override
    public ResultBase edi(Role role) {
        List<Role> list = roleMapper.search(role);
        ResultBase resultBase = ResultUtil.success(null, role);
        if (list.size() > 1) {
            resultBase.setStatus(failure);
            resultBase.setMsg("名称或者编码已存在");
        } else {
            int insert = roleMapper.edi(role);
        }
        return resultBase;
    }

    @Override
    public ResultBase listByUser(String queryKey, Integer roleId, Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<User> list = userMapper.selectUserByRoleId(queryKey, roleId);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return ResultUtil.success(null, pageInfo);
    }

    @Override
    public ResultBase permissions(Integer roleId) {
        return ResultUtil.success(null, permissionMapper.selectRolePermissions(roleId));

    }

    @Override
    public ResultBase distributionPermissions(Integer roleId, List<Integer> permissions) {

        rolePermissionMapper.del(roleId);
        //批量添加到数据库中
        List<RolePermission> lists = new ArrayList<>();
        permissions.forEach(permissionsid -> {
            RolePermission roleP = new RolePermission();
            roleP.setPermissionId(permissionsid);
            roleP.setRoleId(roleId);
            lists.add(roleP);
        });
        rolePermissionMapper.addBatch(lists);
        //更新role表中roleId的权限数
        Role role = new Role();
        role.setId(roleId);
        role.setPermissionNum(permissions.size());
        roleMapper.edi(role);
        return ResultUtil.success(null, permissions);
    }
}
