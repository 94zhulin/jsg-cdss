package com.jsg.service;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.AccessAuth;
import com.jsg.entity.Pageable;

/**
 * @author jeanson 进生
 * @date 2019/10/8 19:50
 */
public interface AccessPermissionsService {
    ResultBase add(AccessAuth accessAuth);

    ResultBase list(String queryKey, Integer status, Pageable pageable);

    ResultBase del(Integer accessAuthId);

    ResultBase edi(AccessAuth accessAuth);

}
