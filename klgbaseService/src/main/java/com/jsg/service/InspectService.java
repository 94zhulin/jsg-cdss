package com.jsg.service;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Inspect;
import com.jsg.entity.Pageable;

/**
 * @author jeanson 进生
 * @date 2019/10/17 11:30
 */
public interface InspectService {
    ResultBase del(Integer dinspectId, Integer catalogId);

    ResultBase edi(Inspect inspect);

    ResultBase list(Integer catalogId, String queryKey, String bw, String jcTypeCode, String yxFlagCode, Pageable pageable);

    ResultBase add(Inspect inspect);

}
