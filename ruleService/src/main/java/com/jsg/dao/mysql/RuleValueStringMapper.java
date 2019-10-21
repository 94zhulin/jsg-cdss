package com.jsg.dao.mysql;

import com.jsg.entity.RuleValueString;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleValueStringMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RuleValueString record);

    int insertSelective(RuleValueString record);

    RuleValueString selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RuleValueString record);

    int updateByPrimaryKey(RuleValueString record);
}