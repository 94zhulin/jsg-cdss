package com.jsg.dao.mysql;

import com.jsg.entity.RuleBase;
import com.jsg.entity.RuleBaseKey;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleBaseMapper {
    int deleteByPrimaryKey(RuleBaseKey key);

    int insert(RuleBase record);

    int insertSelective(RuleBase record);

    RuleBase selectByPrimaryKey(RuleBaseKey key);

    int updateByPrimaryKeySelective(RuleBase record);

    int updateByPrimaryKey(RuleBase record);
}