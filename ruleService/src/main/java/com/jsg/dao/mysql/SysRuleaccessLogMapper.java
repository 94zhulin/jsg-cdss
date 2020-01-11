package com.jsg.dao.mysql;


import com.jsg.entity.SysRuleaccessLog;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRuleaccessLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRuleaccessLog record);

    int insertSelective(SysRuleaccessLog record);

    SysRuleaccessLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRuleaccessLog record);

    int updateByPrimaryKey(SysRuleaccessLog record);


}