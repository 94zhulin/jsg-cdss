package com.jsg.service;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Pageable;
import com.jsg.entity.Qualifications;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/14 15:46
 */
public interface BaseinfoService {
    ResultBase list(String queryKey, Integer sex, String ksCode, Integer position, String qlf, Pageable pageable);

    ResultBase ediStatusQlf(String staffId);

    ResultBase add(Qualifications qualifications);

    ResultBase ediStatusZz();

    ResultBase edi(Qualifications qualifications);

    ResultBase del(Integer qualificationId);

    ResultBase addOrEdiRule(Integer staffId, Integer qualificationId, List<Integer> rules);

    ResultBase delRule(Integer qualificationId, Integer ruleId);

    ResultBase delRuleAll(Integer qualificationId);

    ResultBase listByassociationListQualification(String queryKey, Integer staffId, Integer qualificationId, Pageable pageable);
}
