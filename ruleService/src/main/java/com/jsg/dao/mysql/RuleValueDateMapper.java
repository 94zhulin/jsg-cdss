package com.jsg.dao.mysql;

import com.jsg.entity.RuleValueDate;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleValueDateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RuleValueDate record);

    int insertSelective(RuleValueDate record);

    RuleValueDate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RuleValueDate record);

    int updateByPrimaryKey(RuleValueDate record);
}