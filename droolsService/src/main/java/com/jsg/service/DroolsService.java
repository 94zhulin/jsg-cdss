package com.jsg.service;

import com.jsg.base.result.ResultBase;

/**
 * @author jeanson 进生
 * @date 2019/11/26 16:24
 */
public interface DroolsService {
    ResultBase operation(String ruleName, String ruleId);

}
