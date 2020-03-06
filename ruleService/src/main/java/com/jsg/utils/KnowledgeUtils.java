package com.jsg.utils;

import com.jsg.entity.Patients;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.*;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

public class KnowledgeUtils {
    public static void main(String[] args) {
        String str = "package com.jsg.drools\n" +
                "\n" +
                "import com.jsg.entity.*\n" +
                "import java.util.*\n" +
                "import java.lang.*\n" +
                "dialect \"java\"\n" +
                "global java.util.HashMap ruleexecutionResult\n" +
                "\n" +
                "rule \"hui_zhen\"\n" +
                "\tno-loop true \n" +
                "\twhen\n" +
                "\t\tpatientObj:Patients(name == \"会诊\"  &&  endValue=\"RZ-ZZ-YBZZ-02\" );\n" +
                "\tthen\n" +
                "\t\truleexecutionResult.put(drools.getRule().getName(),true);\n" +
                "\t\tSystem.out.println(\"The rule's name is '\" + drools.getRule().getName() + \"'\");\n" +
                "end\n" +
                "\n" +
                "rule \"f_f_s_f_d_g_f_d_s_a_s_f_f_d_a_f_s_d_f\"\n" +
                "\tno-loop true \n" +
                "\twhen\n" +
                "\t\tpatientObj:Patients(name == \"ffsfdgfdsasffdafsdf\"  && endValueNumerical= 4 );\n" +
                "\tthen\n" +
                "\t\truleexecutionResult.put(drools.getRule().getName(),true);\n" +
                "\t\tSystem.out.println(\"The rule's name is '\" + drools.getRule().getName() + \"'\");\n" +
                "end\n" +
                "\n" +
                "rule \"chong_tian_ti_pao_guang_shu\"\n" +
                "\tno-loop true \n" +
                "\twhen\n" +
                "\t\tpatientObj:Patients(name == \"充填体抛光术\"  && endValueBoo= true );\n" +
                "\tthen\n" +
                "\t\truleexecutionResult.put(drools.getRule().getName(),true);\n" +
                "\t\tSystem.out.println(\"The rule's name is '\" + drools.getRule().getName() + \"'\");\n" +
                "end\n" +
                "\n";
        // HashMap<String, Boolean> match = match(str List<Patients> );
/*        Iterator it = match.keySet().iterator();
        String key = null;
        String value = null;
        while (it.hasNext()) {
            key = (String) it.next();
            Boolean aBoolean = match.get(key);
            System.out.println("key:" + key + "---" + "value:" + aBoolean);
        }*/

    }


    public static HashMap<String, Boolean> match(String str, List<Patients> data) {
        StatefulKnowledgeSession kSession = null;
        HashMap<String, Boolean> ruleexecutionResult = new HashMap<>();
        try {
            KnowledgeBuilder kb = KnowledgeBuilderFactory.newKnowledgeBuilder();
            //装入规则，可以装入多个
            kb.add(ResourceFactory.newByteArrayResource(str.toString().getBytes("utf-8")), ResourceType.DRL);

            KnowledgeBuilderErrors errors = kb.getErrors();
            for (KnowledgeBuilderError error : errors) {
                System.out.println(error);
            }
            KnowledgeBase kBase = KnowledgeBaseFactory.newKnowledgeBase();
            kBase.addKnowledgePackages(kb.getKnowledgePackages());
            kSession = kBase.newStatefulKnowledgeSession();
            kSession.setGlobal("ruleexecutionResult", ruleexecutionResult);
            for (Patients s : data) {
                kSession.insert(s);
            }
            kSession.fireAllRules();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            if (kSession != null) {
                kSession.dispose();
            }
            return ruleexecutionResult;
        }

    }


}

