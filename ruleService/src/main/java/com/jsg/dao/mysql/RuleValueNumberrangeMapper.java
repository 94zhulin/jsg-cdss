package com.jsg.dao.mysql;

import com.jsg.entity.RuleValueNumberrange;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleValueNumberrangeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RuleValueNumberrange record);

    int insertSelective(RuleValueNumberrange record);

    RuleValueNumberrange selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RuleValueNumberrange record);

    int updateByPrimaryKey(RuleValueNumberrange record);
}