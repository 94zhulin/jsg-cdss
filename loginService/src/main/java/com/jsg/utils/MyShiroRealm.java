package com.jsg.utils;

import com.jsg.dao.mysql.PermissionMapper;
import com.jsg.dao.mysql.RoleMapper;
import com.jsg.dao.mysql.UserGeneralMapper;
import com.jsg.entity.PermissionGenera;
import com.jsg.entity.RoleGenera;
import com.jsg.entity.UserGenera;
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
    private UserGeneralMapper userGeneralMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserGenera user = (UserGenera) principalCollection.getPrimaryPrincipal();
        RoleGenera roleGenera = user.getRole();
        if (roleGenera.getPermissionGeneras() != null) {
            List<PermissionGenera> list = roleGenera.getPermissionGeneras();
            for (PermissionGenera permissionGenera : list) {
                authorizationInfo.addStringPermission(permissionGenera.getCode());
            }
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = authenticationToken.getPrincipal().toString();
        if ("Android_iOS".equals(username)) {
            UserGenera user = new UserGenera();
            String password = new Md5Hash("phone", null, 2).toString();
            RoleGenera roleGenera = roleMapper.selectRoleById(1);
            if (roleGenera != null) {
                List<PermissionGenera> permissionGeneraList = permissionMapper.selectRolePermissions(roleGenera.getId());
                roleGenera.setPermissionGeneras(permissionGeneraList);
            }
            user.setRole(roleGenera);
            return new SimpleAuthenticationInfo(user, password, getName());
        }
        //     RoleGenera role1 = roleMapper.selectRoleById(1);

        List<UserGenera> list = userGeneralMapper.selectByName(username);
        if (list.size() > 0) {
            UserGenera user = list.get(0);
            if (user != null && user.getStatus() == 1) {
                RoleGenera roleGenera = roleMapper.selectRoleById(user.getRoleId());
                if (roleGenera != null) {
                    List<PermissionGenera> permissionGeneraList = permissionMapper.selectRolePermissions(roleGenera.getId());
                    roleGenera.setPermissionGeneras(permissionGeneraList);
                    user.setRole(roleGenera);
                }
                return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
            }
        }
        return null;
    }
}
