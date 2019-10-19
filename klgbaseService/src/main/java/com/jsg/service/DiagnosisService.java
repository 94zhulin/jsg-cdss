package com.jsg.service;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Diagnosis;
import com.jsg.entity.Pageable;

/**
 * @author jeanson 进生
 * @date 2019/10/17 11:18
 */
public interface DiagnosisService {
    ResultBase del(Integer diagnosisId, Integer catalogId);

    ResultBase edi(Diagnosis diagnosis);

    ResultBase add(Diagnosis diagnosis);

    ResultBase list(Integer catalogId, String queryKey, Integer type, String zzd_flag_code, Pageable pageable);
}
