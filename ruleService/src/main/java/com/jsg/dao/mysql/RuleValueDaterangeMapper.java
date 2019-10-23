package com.jsg.dao.mysql;

import com.jsg.entity.RuleValueDaterange;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleValueDaterangeMapper {

    void add(RuleValueDaterange daterange);

    void delByRuleId(@Param("id") Integer id);
}