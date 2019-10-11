package com.jsg.service;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Hospital;

/**
 * @author jeanson 进生
 * @date 2019/10/8 19:49
 */

public interface HospitalService {
    ResultBase del(Integer hospitalId);

    ResultBase edi(Hospital hospital);

    ResultBase find(Integer hospitalId);

    ResultBase add(Hospital hospital);
}
