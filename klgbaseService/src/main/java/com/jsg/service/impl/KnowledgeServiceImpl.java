package com.jsg.service.impl;

import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import com.jsg.dao.mysql.CatalogMapper;
import com.jsg.entity.Catalog;
import com.jsg.entity.Pageable;
import com.jsg.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author jeanson 进生
 * @date 2019/10/17 11:02
 */
@Service
public class KnowledgeServiceImpl implements KnowledgeService {

    @Autowired
    private CatalogMapper catalogMapper;

    @Value("${apiStatus.failure}")
    private Integer failure;

    @Value("${apiStatus.exc}")
    private Integer exc;

    @Value("${apiStatus.success}")
    private Integer success;

    @Override
    public ResultBase addClass(Catalog catalog) {
        return null;
    }

    @Override
    public ResultBase ediClass(Catalog catalog) {
        return null;
    }

    @Override
    public ResultBase classList(Pageable pageable) {
        return null;
    }

    @Override
    public ResultBase itemNumAdd(Integer catalogId) {
        //TODO 删除的时候要减去 对应目录的  知识项数量
        Catalog catalog = catalogMapper.selectOneById(catalogId);
        Integer itemNum = catalog.getItemNum();
        itemNum++;
        catalog.setId(catalogId);
        catalog.setItemNum(itemNum);
        int edi = catalogMapper.edi(catalog);
        return ResultUtil.success(null, catalog);
    }

    @Override
    public ResultBase itemNumSub(Integer catalogId) {
        //TODO 删除的时候要减去 对应目录的  知识项数量
        Catalog catalog = catalogMapper.selectOneById(catalogId);
        Integer itemNum = catalog.getItemNum();
        itemNum--;
        catalog.setId(catalogId);
        catalog.setItemNum(itemNum);
        int edi = catalogMapper.edi(catalog);
        return ResultUtil.success(null, catalog);
    }
}
