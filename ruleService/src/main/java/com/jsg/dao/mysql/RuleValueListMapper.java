package com.jsg.dao.mysql;

import com.jsg.entity.RuleValueList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleValueListMapper {

    int add(RuleValueList listStr);

    int delByRuleId(@Param("id") Integer id);

    RuleValueList selectByItemId(@Param("itemId") Integer itemId);
}