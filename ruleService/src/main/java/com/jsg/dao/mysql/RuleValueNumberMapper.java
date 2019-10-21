package com.jsg.dao.mysql;

import com.jsg.entity.RuleValueNumber;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleValueNumberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RuleValueNumber record);

    int insertSelective(RuleValueNumber record);

    RuleValueNumber selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RuleValueNumber record);

    int updateByPrimaryKey(RuleValueNumber record);
}