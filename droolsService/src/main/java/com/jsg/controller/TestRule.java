package com.jsg.controller;

import com.github.stuxuhai.jpinyin.PinyinException;
import com.jsg.entity.Patients;
import org.drools.core.impl.InternalKnowledgeBase;
import org.drools.core.impl.KnowledgeBaseFactory;
import org.junit.Test;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderError;
import org.kie.internal.builder.KnowledgeBuilderErrors;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;

import java.util.List;

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
            kSession.insert(test);
            int i = kSession.fireAllRules();
            if (result){
                    System.out.println(result);
            }
            System.out.println("结果:" + i);
        } catch (Exception e) {
            System.out.println("规则执行异常" + e);
        } finally {
            if (null != kSession)
                kSession.dispose();
        }


    }


}
