package com.jsg.dao.mysql;

import com.jsg.entity.AccessAuth;
import com.jsg.entity.Module;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/8 19:54
 */
@Repository
public interface AccessPermissionsMapper {
    List<AccessAuth> search(AccessAuth accessAuth);

    void add(AccessAuth accessAuth);

    List<Module> list(@Param("queryKey") String queryKey, @Param("status") Integer status);

    int del(@Param("accessAuthId") Integer accessAuthId);

    void edi(AccessAuth accessAuth);
}
