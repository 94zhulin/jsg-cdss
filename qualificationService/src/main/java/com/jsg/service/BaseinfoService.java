package com.jsg.service;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Pageable;
import com.jsg.entity.Qualifications;
import com.jsg.entity.pojo.Patients;

import java.util.List;

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

    ResultBase listByassociationListQualification(String queryKey, Integer staffId, String  zzmcCode, Pageable pageable);

    ResultBase detailsByQualification(Integer staffId);

    List<Patients> listByYsCode(String ysCode);

}
