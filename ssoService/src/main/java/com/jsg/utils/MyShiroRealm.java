package com.jsg.utils;

import com.jsg.dao.mysql.PermissionMapper;
import com.jsg.dao.mysql.RoleMapper;
import com.jsg.dao.mysql.UserMapper;
import com.jsg.entity.Permission;
import com.jsg.entity.Role;
import com.jsg.entity.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principalCollection.getPrimaryPrincipal();
        Role role = user.getRole();
        if (role.getPermissions() != null) {
            List<Permission> list = role.getPermissions();
            for (Permission permission : list) {
                authorizationInfo.addStringPermission(permission.getCode());
            }
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = authenticationToken.getPrincipal().toString();
        if ("Android_iOS".equals(username)) {
            User user = new User();
            String password = new Md5Hash("phone", null, 2).toString();
            Role role = roleMapper.selectRoleById(1);
            if (role != null) {
                List<Permission> permissionList = permissionMapper.selectRolePermissions(role.getId());
                role.setPermissions(permissionList);
            }
            user.setRole(role);
            return new SimpleAuthenticationInfo(user, password, getName());
        }
        List<User> list = userMapper.selectByName(username);
        if (list.size() > 0) {
            User user = list.get(0);
            if (user != null && user.getStatus() == 1) {
                Role role = roleMapper.selectRoleById(user.getRoleId());
                if (role != null) {
                    List<Permission> permissionList = permissionMapper.selectRolePermissions(role.getId());
                    role.setPermissions(permissionList);
                    user.setRole(role);
                }
                return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
            }
        }
        return null;
    }
}
