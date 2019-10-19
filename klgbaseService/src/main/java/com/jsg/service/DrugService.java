package com.jsg.service;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Drug;
import com.jsg.entity.Pageable;

/**
 * @author jeanson 进生
 * @date 2019/10/17 11:20
 */
public interface DrugService {
    ResultBase add(Drug drug);

    ResultBase list(Integer catalogId, String queryKey, String jxCode, String pcCode, String gyfsCode, String yysjCode, Pageable pageable);

    ResultBase edi(Drug drug);

    ResultBase del(Integer drugId, Integer catalogId);

}
