package com.jsg.service.impl;

import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import com.jsg.service.DroolsService;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;
import org.springframework.stereotype.Service;

/**
 * @author jeanson 进生
 * @date 2019/11/26 16:24
 */
@Service
public class DroolsServiceImpl implements DroolsService {
    @Override
    public ResultBase operation(String ruleName, String ruleId) {
        /**
         * 思路
         * 1.根据上游传输过来的数据在redis 或mysql中进行 ruleString的检索
         * 2.将检索到是ruleString 放早drools中, 可以放入多个
         */
        KieHelper helper = new KieHelper();
        helper.addContent("规则的字符串", ResourceType.DRL);
        helper.addContent("规则的字符串1", ResourceType.DRL);
        helper.addContent("规则的字符串2", ResourceType.DRL);
        KieSession kSession = helper.build().newKieSession();
        kSession.insert(new Object());
        kSession.fireAllRules();
        kSession.dispose();
        return ResultUtil.success("", null);
    }


}
