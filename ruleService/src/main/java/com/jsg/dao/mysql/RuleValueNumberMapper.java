package com.jsg.dao.mysql;

import com.jsg.entity.RuleValueNumber;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleValueNumberMapper {

    void add(RuleValueNumber number);

    void delByRuleId(@Param("id") Integer id);

    RuleValueNumber selectByItemId(@Param("itemId")Integer itemId);
}