package com.jsg.service;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Pageable;
import com.jsg.entity.Role;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/8 19:46
 */
public interface RoleService {
    ResultBase add(Role role);

    ResultBase list(String queryKey, Integer status, Pageable pageable);

    ResultBase del(Integer roleId);

    ResultBase edi(Role role);

    ResultBase distributionPermissions(Integer roleId, List<Integer> permissions);

    ResultBase listByUser(String queryKey, Integer roleId, Pageable pageable);

    ResultBase permissions(Integer roleId);
}
