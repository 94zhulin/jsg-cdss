package com.jsg.dao.mysql;

import com.jsg.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/8 19:53
 */
@Repository
public interface RoleMapper {
    List<Role> list(@Param("queryKey") String queryKey);

    int add(Role role);

    List<Role> search(Role role);

    int del(@Param("roleId") Integer roleId);

    int edi(Role role);

    Role selectRoleById(@Param("roleId") Integer roleId);
}
