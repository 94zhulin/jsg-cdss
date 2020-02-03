package com.jsg.dao.mysql;

import com.jsg.entity.RuleBase;
import com.jsg.entity.RuleCatalog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RuleBaseMapper {


    List<RuleCatalog> listRule(@Param("catalogId") Integer catalogId, @Param("queryKey") String queryKey, @Param("deployStatus") Integer deployStatus);

    int add(RuleBase ruleBase);

    void edi(RuleBase ruleBase);

    int del(@Param("ruleId") Integer ruleId);

    String selechistoryVersion(@Param("ids") String ids);

    int isDel(@Param("id") Integer id);

    List<RuleBase> ruleHistory(@Param("code") String code, @Param("policyType") String policyType);

    void ruleReduction(@Param("id") Integer id);

    RuleBase findByRuleBase(@Param("id") Integer id);

    int selectByVersion(@Param("code") String code, @Param("policyType") String policyType);

    void updateDeployStatus(@Param("code") String code, @Param("policy_type") Integer policy_type);

}