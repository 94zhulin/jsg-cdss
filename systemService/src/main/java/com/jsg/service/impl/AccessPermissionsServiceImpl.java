package com.jsg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import com.jsg.dao.mysql.AccessPermissionsMapper;
import com.jsg.entity.AccessAuth;
import com.jsg.entity.Pageable;
import com.jsg.service.AccessPermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/9 15:39
 */
@Service
public class AccessPermissionsServiceImpl implements AccessPermissionsService {


    @Autowired
    private AccessPermissionsMapper accessPermissionsMapper;

    @Value("${apiStatus.failure}")
    private Integer failure;

    @Value("${apiStatus.exc}")
    private Integer exc;

    @Value("${apiStatus.success}")
    private Integer success;


    @Override
    public ResultBase add(AccessAuth accessAuth) {

        List<AccessAuth> list = accessPermissionsMapper.search(accessAuth);
        ResultBase resultBase = ResultUtil.success(null, accessAuth);
        if (list.size() > 0) {
            resultBase.setStatus(failure);
            resultBase.setMsg("应用名/编码重复");
        } else {
            accessPermissionsMapper.add(accessAuth);
            resultBase.setData(accessAuth);
        }
        return resultBase;
    }

    @Override
    public ResultBase list(String queryKey, Integer status, Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<AccessAuth> list = accessPermissionsMapper.list(queryKey, status);
        PageInfo<AccessAuth> pageInfo = new PageInfo<>(list);
        return ResultUtil.success(null, pageInfo);
    }

    @Override
    public ResultBase del(Integer accessAuthId) {
        int flag = accessPermissionsMapper.del(accessAuthId);
        return ResultUtil.success(null, flag);
    }

    @Override
    public ResultBase edi(AccessAuth accessAuth) {
        List<AccessAuth> list = accessPermissionsMapper.search(accessAuth);
        ResultBase resultBase = ResultUtil.success(null, accessAuth);
        if (list.size() > 1) {
            resultBase.setStatus(failure);
            resultBase.setMsg("应用名/编码重复");
        } else {
            accessPermissionsMapper.edi(accessAuth);
            resultBase.setData(accessAuth);
        }
        return resultBase;
    }
}
