package com.jsg.dao.mysql;

import com.jsg.entity.Module;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/8 19:53
 */
@Repository
public interface ModuleMapper {
    List<Module> selectByCodeOrUrl(Module module);

    void add(Module module);

    List<Module> list(@Param("moduleId") Integer moduleId);

    List<Module> search(@Param("queryKey") String queryKey, @Param("moduleId") Integer moduleId);

    int del(@Param("moduleId") Integer moduleId);

    int edi(Module module);

}
