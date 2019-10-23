package com.jsg.dao.mysql;

import com.jsg.entity.RuleValueList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleValueListMapper {

    void add(RuleValueList listStr);

    void delByRuleId(@Param("id") Integer id);
}