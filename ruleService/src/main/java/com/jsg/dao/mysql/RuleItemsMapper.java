package com.jsg.dao.mysql;

import com.jsg.entity.RuleItems;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleItemsMapper {

    void add(RuleItems itemTrue);

    void delByRuleId(@Param("id") Integer id);
}