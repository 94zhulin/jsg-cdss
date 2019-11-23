package com.jsg.dao.mysql;

import com.jsg.entity.RolePermissionGenera;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePermissionMapper {
    int del(@Param("roleId") Integer roleId);

    void addBatch(List<RolePermissionGenera> lists);

}