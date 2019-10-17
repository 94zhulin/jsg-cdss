package com.jsg.service;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Catalog;
import com.jsg.entity.Pageable;

/**
 * @author jeanson 进生
 * @date 2019/10/17 11:01
 */
public interface KnowledgeService {
    ResultBase addClass(Catalog catalog);

    ResultBase ediClass(Catalog catalog);

    ResultBase classList(Pageable pageable);

    ResultBase itemNumAdd(Integer catalogId);

    ResultBase itemNumSub(Integer catalogId);
}
