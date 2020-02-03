package com.jsg.dao.mysql;

import com.jsg.entity.RolePermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePermissionMapper {
    int del(@Param("roleId") Integer roleId);

    void addBatch(List<RolePermission> lists);

    List<Integer> selectByPermission(@Param("roleId") Integer roleId);

}