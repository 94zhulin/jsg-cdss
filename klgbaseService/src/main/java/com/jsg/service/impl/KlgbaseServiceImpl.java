package com.jsg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import com.jsg.dao.mysql.*;
import com.jsg.entity.*;
import com.jsg.service.KlgbaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2020/1/5 20:07
 */
@Service
public class KlgbaseServiceImpl implements KlgbaseService {
    @Autowired
    private DiagnosisMapper diagnosisMapper;

    @Autowired
    private DrugMapper drugMapper;

    @Autowired
    private ExamineMapper examineMapper;

    @Autowired
    private HistoryallergyMapper historyallergyMapper;

    @Autowired
    private HzsxMapper hzsxMapper;

    @Autowired
    private InspectMapper inspectMapper;

    @Autowired
    private CatalogMapper catalogMapper;

    @Override
    public ResultBase list(String catalogCode, String queryKey, Pageable pageable) {
        if (catalogCode == null) {
            return ResultUtil.fail("catalogCode  not null ");
        }
        Catalog catalog = new Catalog();
        catalog.setCode(catalogCode);
        List<Catalog> catalogs = catalogMapper.selectByCode(catalog);
        Catalog catalog1 = catalogs.get(0);
        ResultBase success = ResultUtil.success(null, null);
        switch (catalogCode) {
            case "JY":
                PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
                List<Examine> list = examineMapper.list(catalog1.getId(), queryKey, null, null, null);
                PageInfo<Examine> pageInfo = new PageInfo<>(list);
                success.setData(pageInfo);
                break;
            case "JC":
                PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
                List<Diagnosis> list1 = inspectMapper.list(catalog1.getId(), queryKey, null, null, null);
                PageInfo<Diagnosis> pageInfo1 = new PageInfo<>(list1);
                success.setData(pageInfo1);
                break;
            case "GMS":
                PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
                List<Historyallergy> list2 = historyallergyMapper.list(catalog1.getId(), queryKey);
                PageInfo<Historyallergy> pageInfo2 = new PageInfo<>(list2);
                success.setData(pageInfo2);

                break;
            case "YP":
                PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
                List<Drug> list3 = drugMapper.list(catalog1.getId(), queryKey, null, null, null, null);
                PageInfo<Drug> pageInfo3 = new PageInfo<>(list3);
                success.setData(pageInfo3);

                break;
            case "HZ":
                PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
                List<Hzsx> list4 = hzsxMapper.list(catalog1.getId(), queryKey, null);
                PageInfo<Hzsx> pageInfo4 = new PageInfo<>(list4);
                success.setData(pageInfo4);
                break;
            case "ZD":
                PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
                List<Diagnosis> list5 = diagnosisMapper.list(catalog1.getId(), queryKey, null, null);
                PageInfo<Diagnosis> pageInfo5 = new PageInfo<>(list5);
                success.setData(pageInfo5);
                break;
        }

        return success;
    }
}
