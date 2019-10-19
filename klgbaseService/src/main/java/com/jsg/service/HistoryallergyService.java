package com.jsg.service;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Historyallergy;
import com.jsg.entity.Pageable;

/**
 * @author jeanson 进生
 * @date 2019/10/17 11:24
 */
public interface HistoryallergyService {
    ResultBase add(Historyallergy historyallergy);

    ResultBase list(Integer catalogId, String queryKey, Pageable pageable);

    ResultBase edi(Historyallergy historyallergy);

    ResultBase del(Integer diagnosisId, Integer catalogId);
}
