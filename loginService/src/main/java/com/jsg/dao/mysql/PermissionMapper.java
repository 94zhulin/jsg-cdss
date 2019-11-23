package com.jsg.dao.mysql;

import com.jsg.entity.PermissionGenera;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/14 11:19
 */
@Repository
public interface PermissionMapper {


    List<PermissionGenera> selectRolePermissions(@Param("roleId") Integer roleId);

    List<PermissionGenera> selectModulePermissions(@Param("moduleId") Integer moduleId);
}
