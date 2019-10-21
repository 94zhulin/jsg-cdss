package com.jsg.dao.mysql;

import com.jsg.entity.RuleValueBoolean;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleValueBooleanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RuleValueBoolean record);

    int insertSelective(RuleValueBoolean record);

    RuleValueBoolean selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RuleValueBoolean record);

    int updateByPrimaryKey(RuleValueBoolean record);
}