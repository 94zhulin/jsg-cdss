package com.jsg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import com.jsg.dao.mysql.InspectMapper;
import com.jsg.entity.Diagnosis;
import com.jsg.entity.Inspect;
import com.jsg.entity.Pageable;
import com.jsg.service.InspectService;
import com.jsg.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/17 11:30
 */
@Service
public class InspectServiceImpl implements InspectService {

    @Autowired
    private InspectMapper inspectMapper;
    @Autowired
    private KnowledgeService knowledgeService;
    @Value("${apiStatus.failure}")
    private Integer failure;

    @Value("${apiStatus.exc}")
    private Integer exc;

    @Value("${apiStatus.success}")
    private Integer success;


    @Override
    public ResultBase del(Integer inspectId, Integer catalogId) {
        int del = inspectMapper.del(inspectId);
        if (del > 0) {
            knowledgeService.itemNumSub(catalogId);
        }
        return ResultUtil.success(null, del);
    }

    @Override
    public ResultBase edi(Inspect inspect) {
        List<Inspect> inspectList = inspectMapper.selectByNameCode(inspect);
        ResultBase resultBase = ResultUtil.success(null, inspectList);
        if (inspectList.size() > 1) {
            resultBase.setStatus(failure);
            resultBase.setMsg("编码或项目名重复！");
        } else {
            int opFlag = inspectMapper.edi(inspect);
        }
        return resultBase;
    }

    @Override
    public ResultBase list(String queryKey, String bw, String jcTypeCode, String yxFlagCode, Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<Diagnosis> list = inspectMapper.list(queryKey, bw, jcTypeCode, yxFlagCode);
        PageInfo<Diagnosis> pageInfo = new PageInfo<>(list);
        return ResultUtil.success(null, pageInfo);
    }

    @Override
    public ResultBase add(Inspect inspect) {
        List<Inspect> inspectList = inspectMapper.selectByNameCode(inspect);
        ResultBase resultBase = ResultUtil.success(null, inspect);
        if (inspectList.size() > 0) {
            resultBase.setStatus(failure);
            resultBase.setMsg("编码或项目名重复！");
        } else {
            int opFlag = inspectMapper.add(inspect);
            if (inspect.getId() != null) {
                knowledgeService.itemNumAdd(inspect.getCatalogId());
            }
        }
        return resultBase;
    }
}
