package com.jsg.service.impl;

import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import com.jsg.dao.mysql.HospitalMapper;
import com.jsg.entity.Hospital;
import com.jsg.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/9 15:39
 */
@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalMapper hospitalMapper;

    @Value("${apiStatus.failure}")
    private Integer failure;

    @Value("${apiStatus.exc}")
    private Integer exc;

    @Value("${apiStatus.success}")
    private Integer success;


    @Override
    public ResultBase del(Integer hospitalId) {
        int ofFlag = hospitalMapper.del(hospitalId);
        return ResultUtil.success(null, ofFlag);
    }

    @Override
    public ResultBase edi(Hospital hospital) {
        int ofFlag = hospitalMapper.edi(hospital);
        return ResultUtil.success(null, hospital);
    }

    @Override
    public ResultBase find(Integer hospitalId) {
        List<Hospital> lists = hospitalMapper.find(hospitalId);
        return ResultUtil.success(null, lists);
    }

    @Override
    public ResultBase add(Hospital hospital) {
        int ofFlag = hospitalMapper.add(hospital);
        return ResultUtil.success(null, hospital);
    }
}
