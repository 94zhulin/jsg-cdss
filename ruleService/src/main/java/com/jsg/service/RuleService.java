package com.jsg.service;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Pageable;
import com.jsg.entity.RuleBase;
import com.jsg.entity.RuleCatalog;

/**
 * @author jeanson 进生
 * @date 2019/10/21 14:23
 */
public interface RuleService {
    ResultBase addClass(RuleCatalog catalog);

    ResultBase ediClass(RuleCatalog catalog);

    ResultBase classList(String parentId, Pageable pageable);

    ResultBase ruleNumAdd(Integer catalogId);

    ResultBase ruleNumSub(Integer catalogId);

    ResultBase childNumAdd(Integer catalogId);

    ResultBase childNumSub(Integer catalogId);

    ResultBase del(Integer catalogId);

    ResultBase addRule(RuleBase ruleBase);

    ResultBase edlRule(RuleBase ruleBase);

    ResultBase delRule(Integer id, Integer ruleId);

    ResultBase listRule(Integer catalogId, String queryKey, Integer deployStatus, Pageable pageable);

    ResultBase ruleHistory(String ids, Pageable pageable);

    ResultBase ruleReduction(Integer ids, Integer pageable);
}
