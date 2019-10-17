package com.jsg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import com.jsg.dao.mysql.ExamineMapper;
import com.jsg.entity.Examine;
import com.jsg.entity.Pageable;
import com.jsg.service.ExamineService;
import com.jsg.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/17 11:23
 */
@Service
public class ExamineServiceImpl implements ExamineService {
    @Autowired
    private ExamineMapper examineMapper;

    @Autowired
    private KnowledgeService knowledgeService;

    @Value("${apiStatus.failure}")
    private Integer failure;

    @Value("${apiStatus.exc}")
    private Integer exc;

    @Value("${apiStatus.success}")
    private Integer success;


    @Override
    public ResultBase add(Examine examine) {
        List<Examine> examineList = examineMapper.selectByCode(examine.getXmCode());
        ResultBase resultBase = ResultUtil.success(null, examineList);
        if (examineList.size() > 0) {
            resultBase.setStatus(failure);
            resultBase.setMsg("编码重复!");
        } else {
            int opFlag = examineMapper.add(examine);
            if (examine.getId() != null) {
                knowledgeService.itemNumAdd(examine.getCatalogId());
            }
        }
        return resultBase;
    }

    @Override
    public ResultBase list(String queryKey, String xmlxCode, String jyTypeCode, String yblxCode, Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<Examine> list = examineMapper.list(queryKey, xmlxCode, jyTypeCode, yblxCode);
        PageInfo<Examine> pageInfo = new PageInfo<>(list);
        return ResultUtil.success(null, pageInfo);
    }

    @Override
    public ResultBase edi(Examine examine) {
        List<Examine> examineList = examineMapper.selectByCode(examine.getXmCode());
        ResultBase resultBase = ResultUtil.success(null, examineList);
        if (examineList.size() > 1) {
            resultBase.setStatus(failure);
            resultBase.setMsg("编码重复!");
        } else {
            int opFlag = examineMapper.edi(examine);
            if (examine.getId() != null) {
                knowledgeService.itemNumAdd(examine.getCatalogId());
            }
        }
        return resultBase;
    }

    @Override
    public ResultBase del(Integer examineId, Integer catalogId) {
        int del = examineMapper.del(examineId);
        if (del > 0) {
            knowledgeService.itemNumSub(catalogId);
        }
        return ResultUtil.success(null, del);
    }
}
