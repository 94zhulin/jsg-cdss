package com.jsg.service;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Examine;
import com.jsg.entity.Pageable;

/**
 * @author jeanson 进生
 * @date 2019/10/17 11:23
 */
public interface ExamineService {
    ResultBase add(Examine examine);

    ResultBase list(String queryKey, String xmlxCode, String jyTypeCode, String yblxCode, Pageable pageable);

    ResultBase edi(Examine examine);

    ResultBase del(Integer examineId, Integer catalogId);
}
