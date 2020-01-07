package com.jsg.service;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Pageable;

/**
 * @author jeanson 进生
 * @date 2020/1/7 14:46
 */
public interface WorkbenchService {
    ResultBase quickEntry();


    ResultBase logByList(String queryKey, String ruleType, String startTime, String endTime);

    ResultBase list(String resultName, String ruleName, String appCode, String clientType, String ruleCatalogName, Pageable pageable);

    ResultBase barChart(String startTime, String endTime);
}
