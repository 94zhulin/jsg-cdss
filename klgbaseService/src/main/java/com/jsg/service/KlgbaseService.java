package com.jsg.service;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Pageable;

/**
 * @author jeanson 进生
 * @date 2020/1/5 20:06
 */
public interface KlgbaseService {
    ResultBase list(String catalogCode, String queryKey, Pageable pageable);

    ResultBase RecommendedProject(String zdbm,String xmbm ,String xmlx,String  queryKey);
}
