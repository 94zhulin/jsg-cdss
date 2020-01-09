package com.jsg.dao.mysql;

import com.jsg.entity.RuleDrools;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleDroolsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RuleDrools record);

    int insertSelective(RuleDrools record);

    RuleDrools selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RuleDrools record);

    int updateByPrimaryKey(RuleDrools record);

    int updateByRuleBaseId(RuleDrools record);

}