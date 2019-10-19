package com.jsg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import com.jsg.dao.mysql.HzsxMapper;
import com.jsg.entity.Hzsx;
import com.jsg.entity.Pageable;
import com.jsg.service.HzsxService;
import com.jsg.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/17 11:27
 */
@Service
public class HzsxServiceImpl implements HzsxService {


    @Autowired
    private HzsxMapper hzsxMapper;
    @Autowired
    private KnowledgeService knowledgeService;
    @Value("${apiStatus.failure}")
    private Integer failure;

    @Value("${apiStatus.exc}")
    private Integer exc;

    @Value("${apiStatus.success}")
    private Integer success;


    @Override
    public ResultBase del(Integer hzsxId, Integer catalogId) {
        int del = hzsxMapper.del(hzsxId);
        if (del > 0) {
            knowledgeService.itemNumSub(catalogId);
        }
        return ResultUtil.success(null, del);
    }

    @Override
    public ResultBase edi(Hzsx hzsx) {
        List<Hzsx> hzsxs = hzsxMapper.selectByCode(hzsx.getCode());
        ResultBase resultBase = ResultUtil.success(null, hzsx);
        if (hzsxs.size() > 1) {
            resultBase.setStatus(failure);
            resultBase.setMsg("编码或项目名重复！");
        } else {
            int opFlag = hzsxMapper.edi(hzsx);
        }
        return resultBase;
    }

    @Override
    public ResultBase list(Integer catalogId, String queryKey, Integer valueType, Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<Hzsx> list = hzsxMapper.list(catalogId, queryKey, valueType);
        PageInfo<Hzsx> pageInfo = new PageInfo<>(list);
        return ResultUtil.success(null, pageInfo);
    }

    @Override
    public ResultBase add(Hzsx hzsx) {
        List<Hzsx> hzsxList = hzsxMapper.selectByCode(hzsx.getCode());
        ResultBase resultBase = ResultUtil.success(null, hzsx);
        if (hzsxList.size() > 0) {
            resultBase.setStatus(failure);
            resultBase.setMsg("编码或项目名重复！");
        } else {
            int opFlag = hzsxMapper.add(hzsx);
            if (hzsx.getId() != null) {
                knowledgeService.itemNumAdd(hzsx.getCatalogId());
            }
        }
        return resultBase;
    }
}
