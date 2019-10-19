package com.jsg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import com.jsg.dao.mysql.HistoryallergyMapper;
import com.jsg.entity.Historyallergy;
import com.jsg.entity.Pageable;
import com.jsg.service.HistoryallergyService;
import com.jsg.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/17 11:25
 */
@Service
public class HistoryallergyServiceImpl implements HistoryallergyService {

    @Autowired
    private HistoryallergyMapper historyallergyMapper;

    @Autowired
    private KnowledgeService knowledgeService;

    @Value("${apiStatus.failure}")
    private Integer failure;

    @Value("${apiStatus.exc}")
    private Integer exc;

    @Value("${apiStatus.success}")
    private Integer success;


    @Override
    public ResultBase add(Historyallergy historyallergy) {
        List<Historyallergy> historyallergyList = historyallergyMapper.selectByCode(historyallergy.getCode());
        ResultBase resultBase = ResultUtil.success(null, historyallergy);
        if (historyallergyList.size() > 0) {
            resultBase.setStatus(failure);
            resultBase.setMsg("编码重复!");
        } else {
            int opFlag = historyallergyMapper.add(historyallergy);
            if (historyallergy.getId() != null) {
                knowledgeService.itemNumAdd(historyallergy.getCatalogId());
            }
        }
        return resultBase;
    }

    @Override
    public ResultBase list(Integer catalogId, String queryKey, Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<Historyallergy> list = historyallergyMapper.list(catalogId, queryKey);
        PageInfo<Historyallergy> pageInfo = new PageInfo<>(list);
        return ResultUtil.success(null, pageInfo);
    }

    @Override
    public ResultBase edi(Historyallergy historyallergy) {
        List<Historyallergy> historyallergyList = historyallergyMapper.selectByCode(historyallergy.getCode());
        ResultBase resultBase = ResultUtil.success(null, historyallergy);
        if (historyallergyList.size() > 1) {
            resultBase.setStatus(failure);
            resultBase.setMsg("编码重复!");
        } else {
            int opFlag = historyallergyMapper.edi(historyallergy);
            if (historyallergy.getId() != null) {
                knowledgeService.itemNumAdd(historyallergy.getCatalogId());
            }
        }
        return resultBase;
    }

    @Override
    public ResultBase del(Integer historyallergyId, Integer catalogId) {
        int del = historyallergyMapper.del(historyallergyId);
        if (del > 0) {
            knowledgeService.itemNumSub(catalogId);
        }
        return ResultUtil.success(null, del);
    }
}
