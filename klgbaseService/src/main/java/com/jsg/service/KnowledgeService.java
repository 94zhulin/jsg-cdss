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

    ResultBase classList(String parentId, Pageable pageable);

    ResultBase itemNumAdd(Integer catalogId);

    ResultBase itemNumSub(Integer catalogId);

    ResultBase childNumAdd(Integer catalogId);

    ResultBase childNumSub(Integer catalogId);

    ResultBase del(Integer catalogId);

    ResultBase hisItems(String type, String queryKey, Pageable pageable);

}
