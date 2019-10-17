package com.jsg.service;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Pageable;
import com.jsg.entity.Qualifications;

/**
 * @author jeanson 进生
 * @date 2019/10/14 15:46
 */
public interface BaseinfoService {
    ResultBase list(String queryKey, Integer sex, String ksCode, Integer position, String qlf, Pageable pageable);

    ResultBase ediStatusQualifications(Integer staffId, Integer status);

    ResultBase add(Qualifications qualifications);

    ResultBase ediStatusZz(Integer qualificationsId, Integer status);

    ResultBase edi(Qualifications qualifications);

    ResultBase del(Integer qualificationId);

    ResultBase listByassociationListQualification(String queryKey, Integer staffId, Integer qualificationId, Pageable pageable);
}
