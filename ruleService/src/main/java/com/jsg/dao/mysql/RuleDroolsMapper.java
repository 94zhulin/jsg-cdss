package com.jsg.dao.mysql;

import com.jsg.entity.Patients;
import com.jsg.entity.RuleDrools;
import com.jsg.entity.RuleItems;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RuleDroolsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RuleDrools record);

    int insertSelective(RuleDrools record);

    RuleDrools selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RuleDrools record);

    int updateByPrimaryKey(RuleDrools record);

    int updateByRuleBaseId(RuleDrools record);

    List<RuleItems> selectByItemCode(@Param("ruleBaseid") Integer ruleBaseid, @Param("itemCode") String itemCode);

    List<RuleDrools> selectRuleStrByCode(@Param("itemCode") String itemCode);

    void updateStatus(@Param("code") String code, @Param("policy_type") Integer policy_type);

    List<Patients> listByYsCode(@Param("ysCode") String ysCode);


}