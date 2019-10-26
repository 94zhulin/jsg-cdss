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

    List<RuleBase> ruleHistory(@Param("ids") String ids);

    void ruleReduction(@Param("id") Integer id);
}