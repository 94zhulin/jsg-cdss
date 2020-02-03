package com.jsg.dao.mysql;

import com.jsg.entity.RuleValueString;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleValueStringMapper {

    int add(RuleValueString string);

    int delByRuleId(@Param("id") Integer id);

    RuleValueString selectByItemId(@Param("itemId")Integer itemId);
}