package com.jsg.dao.mysql;

import com.jsg.entity.RuleValueString;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleValueStringMapper {

    void add(RuleValueString string);

    void delByRuleId(@Param("id") Integer id);

    RuleValueString selectByItemId(@Param("itemId")Integer itemId);
}