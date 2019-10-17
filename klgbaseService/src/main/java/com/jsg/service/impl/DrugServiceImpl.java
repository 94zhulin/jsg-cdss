package com.jsg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import com.jsg.dao.mysql.DrugMapper;
import com.jsg.entity.Diagnosis;
import com.jsg.entity.Drug;
import com.jsg.entity.Pageable;
import com.jsg.service.DrugService;
import com.jsg.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/17 11:20
 */
@Service
public class DrugServiceImpl implements DrugService {


    @Autowired
    private DrugMapper drugMapper;

    @Autowired
    private KnowledgeService knowledgeService;

    @Value("${apiStatus.failure}")
    private Integer failure;

    @Value("${apiStatus.exc}")
    private Integer exc;

    @Value("${apiStatus.success}")
    private Integer success;


    @Override
    public ResultBase add(Drug drug) {
        List<Drug> diagnosisList = drugMapper.selectByCode(drug.getCode());
        ResultBase resultBase = ResultUtil.success(null, diagnosisList);
        if (diagnosisList.size() > 0) {
            resultBase.setStatus(failure);
            resultBase.setMsg("编码重复!");
        } else {
            int opFlag = drugMapper.add(drug);
            if (drug.getId() != null) {
                knowledgeService.itemNumAdd(drug.getCatalogId());
            }
        }
        return resultBase;
    }

    @Override
    public ResultBase list(String queryKey, String jxCode, String pcCode, String gyfsCode, String yysjCode, Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<Diagnosis> list = drugMapper.list(queryKey, jxCode, pcCode, gyfsCode, yysjCode);
        PageInfo<Diagnosis> pageInfo = new PageInfo<>(list);
        return ResultUtil.success(null, pageInfo);
    }

    @Override
    public ResultBase edi(Drug drug) {
        List<Drug> drugList = drugMapper.selectByCode(drug.getCode());
        ResultBase resultBase = ResultUtil.success(null, drugList);
        if (drugList.size() > 1) {
            resultBase.setStatus(failure);
            resultBase.setMsg("编码重复！");
        } else {
            int opFlag = drugMapper.edi(drug);
        }
        return resultBase;
    }

    @Override
    public ResultBase del(Integer drugId, Integer catalogId) {
        int del = drugMapper.del(drugId);
        if (del > 0) {
            knowledgeService.itemNumSub(catalogId);
        }
        return ResultUtil.success(null, del);
    }
}
