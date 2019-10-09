package com.jsg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jsg.base.result.ResultBase;
import com.jsg.dao.mysql.PropertiesMapper;
import com.jsg.entity.Pageable;
import com.jsg.entity.Properties;
import com.jsg.service.PropertiesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/9 15:38
 */
@Service
@Slf4j
public class PropertiesServiceImpl implements PropertiesService {

    @Autowired
    private PropertiesMapper propertiesMapper;

    @Value("${apiStatus.failure}")
    private Integer failure;

    @Value("${apiStatus.exc}")
    private Integer exc;

    @Value("${apiStatus.success}")
    private Integer success;

    @Override
    public ResultBase list(String queryKey, Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<Properties> lists = propertiesMapper.list(queryKey);
        PageInfo pageInfo = new PageInfo(lists);
        return ResultBase.initializeBase(pageInfo, success, null);
    }

    @Override
    public ResultBase del(String propName) {
        int opFlag = propertiesMapper.del(propName);
        ResultBase resultBase = ResultBase.initializeBase(opFlag, success, null);
        if (opFlag < 0) {
            resultBase.setStatus(failure);
            resultBase.setMsg("删除失败,请检查参数是否正确 ！");
        }
        return resultBase;
    }

    @Override
    public ResultBase add(Properties properties) {


        List<Properties> propList = propertiesMapper.selectByPropName(properties.getPropName());
        ResultBase resultBase = ResultBase.initializeBase(1, success, null);
        if (propList.size() > 0) {
            resultBase.setStatus(failure);
            resultBase.setMsg("属性名重复！");
        } else {
            int opFlag = propertiesMapper.add(properties);
            if (opFlag < 0) {
                resultBase.setStatus(failure);
                resultBase.setMsg("添加失败,请检查参数是否正确 ！");
            }
        }
        return resultBase;
    }

    @Override
    public ResultBase edi(Properties properties) {
        @NotNull String propName = properties.getPropName();
        @NotNull String propValue = properties.getPropValue();
        @NotNull Integer status = properties.getStatus();
        @NotNull Integer updateUserId = properties.getUpdateUserId();
        List<Properties> Lists = propertiesMapper.selectByPropName(propName);
        ResultBase resultBase = ResultBase.initializeBase(1, success, null);
        if (Lists.size() > 1) {
            resultBase.setStatus(failure);
            resultBase.setMsg("属性名重复 ！");
        } else {
            int opFlag = propertiesMapper.edi(properties);
            if (opFlag < 0) {
                resultBase.setStatus(failure);
                resultBase.setMsg("编辑失败,请检查参数是否正确 ！");
            }
        }
        return resultBase;
    }

    @Override
    public ResultBase selectByPropName(String propName) {
        List<Properties> propList = propertiesMapper.selectByPropName(propName);
        ResultBase resultBase = ResultBase.initializeBase(propList, success, null);
        if (propList.size() > 0) {
            resultBase.setStatus(failure);
            resultBase.setMsg("属性名重复！");
        }
        return resultBase;
    }
}
