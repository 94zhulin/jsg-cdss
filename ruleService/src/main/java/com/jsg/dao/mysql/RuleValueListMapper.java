package com.jsg.dao.mysql;

import com.jsg.entity.RuleValueList;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleValueListMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RuleValueList record);

    int insertSelective(RuleValueList record);

    RuleValueList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RuleValueList record);

    int updateByPrimaryKey(RuleValueList record);
}