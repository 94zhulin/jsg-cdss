package com.jsg.dao.mysql;

import com.jsg.entity.RuleValueDaterange;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleValueDaterangeMapper {

    int add(RuleValueDaterange daterange);

    int delByRuleId(@Param("id") Integer id);

    RuleValueDaterange selectByItemId(@Param("itemId") Integer itemId);
}