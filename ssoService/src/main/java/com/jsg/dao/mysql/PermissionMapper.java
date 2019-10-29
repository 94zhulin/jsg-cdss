package com.jsg.dao.mysql;

import com.jsg.entity.Permission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/14 11:19
 */
@Repository
public interface PermissionMapper {


    List<Permission> selectRolePermissions(@Param("roleId") Integer roleId);

    List<Permission> selectModulePermissions(@Param("moduleId") Integer moduleId);
}
