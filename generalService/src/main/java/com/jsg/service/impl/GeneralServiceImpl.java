package com.jsg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import com.jsg.dao.mysql.GeneralMapper;
import com.jsg.entity.Department;
import com.jsg.entity.Dictionary;
import com.jsg.entity.Pageable;
import com.jsg.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/26 17:17
 */
@Service
public class GeneralServiceImpl implements GeneralService {

    @Autowired
    private GeneralMapper gneralMapper;

    @Value("${apiStatus.failure}")
    private Integer failure;

    @Value("${apiStatus.exc}")
    private Integer exc;

    @Value("${apiStatus.success}")
    private Integer success;


    @Override
    public ResultBase department(String queryKey, Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<Department> list = gneralMapper.department(queryKey);
        PageInfo<Department> pageInfo = new PageInfo<>(list);
        return ResultUtil.success(null, pageInfo);
    }

    @Override
    public ResultBase dictionary(String queryKey, String catalogId, Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<Dictionary> list = gneralMapper.dictionary(queryKey, catalogId);
        PageInfo<Dictionary> pageInfo = new PageInfo<>(list);
        return ResultUtil.success(null, pageInfo);
    }
}
