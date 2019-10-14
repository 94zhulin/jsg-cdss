package com.jsg.dao.mysql;

import com.jsg.entity.ModulePermission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/14 11:58
 */
@Repository
public interface ModulePermissionMapper {
    void addBatch(List<ModulePermission> lists);

    void del(Integer moduleId);
}
