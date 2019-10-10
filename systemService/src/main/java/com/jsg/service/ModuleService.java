package com.jsg.service;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Module;
import com.jsg.entity.Pageable;

/**
 * @author jeanson 进生
 * @date 2019/10/8 19:46
 */
public interface ModuleService {
    ResultBase add(Module module);

    ResultBase list(Pageable pageable);

    ResultBase search(String queryKey, Integer moduleId, Pageable pageable);

    ResultBase del(Integer moduleId);

    ResultBase edi(Module module);
}
