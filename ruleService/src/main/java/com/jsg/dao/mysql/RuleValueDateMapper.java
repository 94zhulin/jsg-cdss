package com.jsg.dao.mysql;

import com.jsg.entity.RuleValueDate;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleValueDateMapper {

    int add(RuleValueDate date);

    int delByRuleId(@Param("id") Integer id);

    RuleValueDate selectByItemId(@Param("itemId")Integer itemId);
}