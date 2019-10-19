package com.jsg.service;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Hzsx;
import com.jsg.entity.Pageable;

/**
 * @author jeanson 进生
 * @date 2019/10/17 11:27
 */
public interface HzsxService {
    ResultBase del(Integer hzsxId, Integer catalogId);

    ResultBase edi(Hzsx hzsx);

    ResultBase list(Integer catalogId, String queryKey, Integer valueType, Pageable pageable);

    ResultBase add(Hzsx hzsx);
}
