package com.jsg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jsg.base.result.ResultBase;
import com.jsg.dao.mysql.ModuleMapper;
import com.jsg.entity.Module;
import com.jsg.entity.Pageable;
import com.jsg.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/9 15:40
 */
@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModuleMapper moduleMapper;

    @Value("${apiStatus.failure}")
    private Integer failure;

    @Value("${apiStatus.exc}")
    private Integer exc;

    @Value("${apiStatus.success}")
    private Integer success;


    @Override
    public ResultBase add(Module module) {
        List<Module> list = moduleMapper.selectByCodeOrUrl(module);
        ResultBase resultBase = ResultBase.initializeBase(null, success, null);
        if (list.size() > 0) {
            resultBase.setStatus(failure);
            resultBase.setMsg("编码或URL重复");
        } else {
            moduleMapper.add(module);
            resultBase.setData(module);
        }
        return resultBase;
    }

    @Override
    public ResultBase list(Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<Module> list = moduleMapper.list(0);
        PageInfo<Module> pageInfo = new PageInfo<>(list);
        return ResultBase.initializeBase(pageInfo, success, null);
    }

    @Override
    public ResultBase search(String queryKey, Integer moduleId, Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<Module> list = moduleMapper.search(queryKey, moduleId);
        PageInfo<Module> pageInfo = new PageInfo<>(list);
        return ResultBase.initializeBase(pageInfo, success, null);
    }

    @Override
    public ResultBase del(Integer moduleId) {
        int opFlag = moduleMapper.del(moduleId);
        return ResultBase.initializeBase(opFlag, success, null);
    }

    @Override
    public ResultBase edi(Module module) {
        List<Module> list = moduleMapper.selectByCodeOrUrl(module);
        ResultBase resultBase = ResultBase.initializeBase(null, success, null);
        if (list.size() > 1) {
            resultBase.setStatus(failure);
            resultBase.setMsg("编码或URL重复");
        } else {
            moduleMapper.edi(module);
            resultBase.setData(module);
        }
        return resultBase;
    }
}
