package com.jsg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import com.jsg.dao.mysql.DiagnosisMapper;
import com.jsg.entity.Diagnosis;
import com.jsg.entity.Pageable;
import com.jsg.service.DiagnosisService;
import com.jsg.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/17 11:19
 */
@Service
public class DiagnosisServiceImpl implements DiagnosisService {


    @Autowired
    private DiagnosisMapper diagnosisMapper;

    @Autowired
    private KnowledgeService knowledgeService;

    @Value("${apiStatus.failure}")
    private Integer failure;

    @Value("${apiStatus.exc}")
    private Integer exc;

    @Value("${apiStatus.success}")
    private Integer success;

    @Override
    public ResultBase del(Integer diagnosisId, Integer catalogId) {
        int del = diagnosisMapper.del(diagnosisId);
        if (del > 0) {
            knowledgeService.itemNumSub(catalogId);
        }
        return ResultUtil.success(null, del);
    }

    @Override
    public ResultBase edi(Diagnosis diagnosis) {
        List<Diagnosis> diagnosisList = diagnosisMapper.selectByIcd10Code(diagnosis.getIcd10Code());
        ResultBase resultBase = ResultUtil.success(null, diagnosisList);
        if (diagnosisList.size() > 1) {
            resultBase.setStatus(failure);
            resultBase.setMsg("ICD10编码重复！");
        } else {
            int opFlag = diagnosisMapper.edi(diagnosis);
        }
        return resultBase;
    }

    @Override
    public ResultBase add(Diagnosis diagnosis) {
        List<Diagnosis> diagnosisList = diagnosisMapper.selectByIcd10Code(diagnosis.getIcd10Code());
        ResultBase resultBase = ResultUtil.success(null, diagnosisList);
        if (diagnosisList.size() > 0) {
            resultBase.setStatus(failure);
            resultBase.setMsg("ICD10编码重复！");
        } else {
            int opFlag = diagnosisMapper.add(diagnosis);
            if (diagnosis.getId() != null) {
                knowledgeService.itemNumAdd(diagnosis.getCatalogId());
            }
        }
        return resultBase;
    }

    @Override
    public ResultBase list(String queryKey, Integer type, Integer zzdFlagCode, Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<Diagnosis> list = diagnosisMapper.list(queryKey, type, zzdFlagCode);
        PageInfo<Diagnosis> pageInfo = new PageInfo<>(list);
        return ResultUtil.success(null, pageInfo);
    }
}
