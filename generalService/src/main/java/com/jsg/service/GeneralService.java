package com.jsg.service;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Pageable;

/**
 * @author jeanson 进生
 * @date 2019/10/26 17:16
 */
public interface GeneralService {
    ResultBase department(String queryKey, Pageable pageable);

    ResultBase dictionary(String queryKey, String catalogId, Pageable pageable);
}
