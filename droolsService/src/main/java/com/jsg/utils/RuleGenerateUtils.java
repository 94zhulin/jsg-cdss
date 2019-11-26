package com.jsg.utils;

/**
 * @author jeanson 进生
 * @date 2019/11/26 16:29
 */
public class RuleGenerateUtils {


    public String rule2Drl() {
        StringBuilder result = new StringBuilder();
        /*package部分*/
        result.append("package rule1;\r\n");
        result.append("\r\n");

        /*导包部分*/
        result.append("import com.winning.rules.engine.model.Fact;\r\n");
        result.append("import com.winning.rules.engine.model.FactProperty;\r\n");
        result.append("import java.util.List;\r\n");
        result.append("\r\n");

        /*规则申明部分*/
        result.append("rule \"32353242\"\r\n");

        /*规则属性部分*/

        /*规则条件部分*/
        result.append("\twhen\r\n");
        result.append("\t\teval(true)\r\n");

        /*规则结果部分*/
        result.append("\tthen\r\n");
        result.append("\t\tSystem.out.println(\"动态加载的规则被触发了\");\r\n");

        /*规则结束*/
        result.append("end\r\n");
        return result.toString();
    }
}
