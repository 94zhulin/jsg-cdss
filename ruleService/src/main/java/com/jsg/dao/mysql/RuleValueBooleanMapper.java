package com.jsg.dao.mysql;

import com.jsg.entity.RuleValueBoolean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleValueBooleanMapper {


    int add(RuleValueBoolean boo);

    int delByRuleId(@Param("id") Integer id);

    RuleValueBoolean selectByItemId(@Param("itemId") Integer itemId);

}