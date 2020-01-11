package com.jsg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import com.jsg.dao.mysql.SysRuleaccessLogMapper;
import com.jsg.entity.BarChart;
import com.jsg.entity.Pageable;
import com.jsg.entity.QuickEntry;
import com.jsg.entity.SysRuleaccessLog;
import com.jsg.service.WorkbenchService;
import com.jsg.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jeanson 进生
 * @date 2020/1/7 14:47
 */
@Service
public class WorkbenchServiceImpl implements WorkbenchService {

    @Autowired
    private SysRuleaccessLogMapper sysRuleaccessLogMapper;


    @Override
    public ResultBase quickEntry() {
        QuickEntry quickEntry = sysRuleaccessLogMapper.quickEntry();
        return ResultUtil.success("", quickEntry);
    }

    @Override
    public ResultBase logByList(String queryKey, String ruleType, String startTime, String endTime) {
        String starDate = startTime + " 00:00:00";
        String endDate = endTime + " 23:59:59";
        List<Map<String, String>> lists = sysRuleaccessLogMapper.logByList(queryKey, ruleType, starDate, endDate);
        List<String> names = new ArrayList<>();
        names.add("警告");
        names.add("拦截");
        names.add("建议");
        Integer total = 0;
        String number = null;
        Map<String, String> result = new HashMap<>();
        for (String name : names) {
            Boolean flag = false;
            for (Map<String, String> map : lists) {
                String result_name = map.get("result_name");
                if (name.equals(result_name)) {
                    number = map.get("number");
                    total += Integer.valueOf("number");
                    flag = true;
                }
            }
            if (flag) {
                result.put(name, number);
            } else {
                result.put(name, "0");
            }
        }
        result.put("访问总次数", total + "");
        return ResultUtil.success("", result);
    }

    @Override
    public ResultBase list(String resultName, String ruleName, String appCode, String clientType, String ruleCatalogName, Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<SysRuleaccessLog> lists = sysRuleaccessLogMapper.list(resultName, ruleName, appCode, clientType, ruleCatalogName);
        PageInfo<SysRuleaccessLog> pageInfo = new PageInfo<>(lists);
        return ResultUtil.success(null, pageInfo);

    }

    @Override
    public ResultBase barChart(String startTime, String endTime) {
        Integer groupType = 1;
        List<String> betweenDate = DateUtils.getBetweenDate(startTime, endTime);
        String starDate = startTime + " 00:00:00";
        String endDate = endTime + " 23:59:59";
        List<BarChart> lists = sysRuleaccessLogMapper.barChart(starDate, endDate, groupType);
        for (String dateStr : betweenDate) {
            Boolean flag = false;
            for (BarChart bar : lists) {
                String hours = bar.getHours();
                if (dateStr.equals(hours)) {
                    flag = true;
                }
            }
            if (!flag) {
                BarChart chart = new BarChart();
                chart.setHours(dateStr);
                chart.setCount(0);
                lists.add(chart);
            }

        }
        Map<String, Object> hash = new HashMap<>();
        hash.put("sjList", betweenDate);
        hash.put("dataList", lists);
        return ResultUtil.success(null, hash);

    }

}
