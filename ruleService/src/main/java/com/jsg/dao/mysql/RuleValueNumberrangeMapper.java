package com.jsg.dao.mysql;

import com.jsg.entity.RuleValueNumberrange;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleValueNumberrangeMapper {

    int add(RuleValueNumberrange range);

    int delByRuleId(@Param("id") Integer id);

    RuleValueNumberrange selectByItemId(@Param("itemId")Integer itemId);
}