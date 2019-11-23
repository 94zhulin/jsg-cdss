package com.jsg.dao.mysql;

import com.jsg.entity.RoleGenera;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/8 19:53
 */
@Repository
public interface RoleMapper {
    List<RoleGenera> list(@Param("queryKey") String queryKey, @Param("status") Integer status);

    int add(RoleGenera role);

    List<RoleGenera> search(RoleGenera role);

    int del(@Param("roleId") Integer roleId);

    int edi(RoleGenera role);

    RoleGenera selectRoleById(@Param("roleId") Integer roleId);
}
