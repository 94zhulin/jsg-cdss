package com.jsg.dao.mysql;

import com.jsg.entity.RuleValueDaterange;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleValueDaterangeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RuleValueDaterange record);

    int insertSelective(RuleValueDaterange record);

    RuleValueDaterange selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RuleValueDaterange record);

    int updateByPrimaryKey(RuleValueDaterange record);
}