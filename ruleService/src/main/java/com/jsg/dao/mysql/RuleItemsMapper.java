package com.jsg.dao.mysql;

import com.jsg.entity.RuleItems;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleItemsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RuleItems record);

    int insertSelective(RuleItems record);

    RuleItems selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RuleItems record);

    int updateByPrimaryKey(RuleItems record);
}