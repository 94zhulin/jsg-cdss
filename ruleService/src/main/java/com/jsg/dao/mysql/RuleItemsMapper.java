package com.jsg.dao.mysql;

import com.jsg.entity.RuleItems;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RuleItemsMapper {

    void add(RuleItems itemTrue);

    void delByRuleId(@Param("id") Integer id);

    List<RuleItems> selectItems(@Param("ruleId") Integer ruleId, @Param("itemType") int itemType, @Param("conditionType") int conditionType);

    List<RuleItems> selectItemsByOther(@Param("ruleId") Integer ruleId, @Param("itemType") int itemType);

}