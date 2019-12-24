package com.jsg.controller;

import com.github.stuxuhai.jpinyin.PinyinException;
import com.jsg.entity.Patients;
import com.jsg.utils.GenerateRulesUtils;
import org.drools.core.impl.InternalKnowledgeBase;
import org.drools.core.impl.KnowledgeBaseFactory;
import org.junit.Test;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderError;
import org.kie.internal.builder.KnowledgeBuilderErrors;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author jeanson 进生
 * @date 2019/12/21 15:41
 */
public class TestRule {


    @Test
    public void rulesMatch() throws PinyinException {
        List<Patients> patients = GenerateRulesUtils.testData();
        String rule = GenerateRulesUtils.generateRules(patients);
        KieSession kSession = null;
        try {
            // 从数据库根据code查规则
            KnowledgeBuilder kb = KnowledgeBuilderFactory.newKnowledgeBuilder();
            kb.add(ResourceFactory.newByteArrayResource(rule.getBytes("utf-8")), ResourceType.DRL);

            // 检查规则正确性
            KnowledgeBuilderErrors errors = kb.getErrors();
            for (KnowledgeBuilderError error : errors) {
                System.out.println("规则文件正确性有误" + error);
            }
            InternalKnowledgeBase kBase = KnowledgeBaseFactory.newKnowledgeBase();
            kBase.addPackages(kb.getKnowledgePackages());

            Patients test = new Patients();
            test.setItemName("年龄");
            test.setKlgItemValueType(2);
            test.setType(2);
            test.setStartValue("12");
            test.setRootCompare(0);
            test.setEndValueInt(12);
            test.setPinyin("nian_ling");
            Boolean result = test.getResult();
            // 执行规则
            kSession = kBase.newKieSession();
            HashMap<String, Boolean> ruleexecutionResult = new HashMap<>();
            kSession.setGlobal("ruleexecutionResult", ruleexecutionResult);
            FactHandle insert = kSession.insert(test);
            int i = kSession.fireAllRules();
            System.out.println("结果:" + i);
            Set<String> keys = ruleexecutionResult.keySet();

            //TODO  条件数量字段
            int count = 12;
            for (String key : keys) {
                Boolean value = ruleexecutionResult.get(key);
                System.out.println("key：" + key + "---" + "value:" + value);
            }

        } catch (Exception e) {
            System.out.println("规则执行异常" + e);
        } finally {
            if (null != kSession)
                kSession.dispose();
        }


    }


}
