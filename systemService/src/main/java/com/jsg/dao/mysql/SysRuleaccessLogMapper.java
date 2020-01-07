package com.jsg.dao.mysql;

import com.jsg.entity.BarChart;
import com.jsg.entity.QuickEntry;
import com.jsg.entity.SysRuleaccessLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SysRuleaccessLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRuleaccessLog record);

    int insertSelective(SysRuleaccessLog record);

    SysRuleaccessLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRuleaccessLog record);

    int updateByPrimaryKey(SysRuleaccessLog record);

    List<Map<String, String>> logByList(@Param("queryKey") String queryKey, @Param("ruleType") String ruleType, @Param("startTime") String startTime, @Param("endTime") String endTime);

    QuickEntry quickEntry();

    List<SysRuleaccessLog> list(
            @Param("resultName") String resultName, @Param("ruleName") String ruleName, @Param("appCode")
            String appCode, @Param("clientType") String clientType, @Param("ruleCatalogName") String ruleCatalogName);


    List<BarChart> barChart(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("groupType") Integer groupType);

}