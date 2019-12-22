package com.jsg.controller;

import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.jsg.entity.Patients;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/12/20 23:00
 */
public class GenerateRulesUtils {

    public static void main(String[] args) throws PinyinException {
    }

    public static List<Patients> testData() {
        String packageName = "B超";
        List<Patients> patientss = new ArrayList<>();
        //人资
        //     klgItemValueType; //知识库属性值类型：1-布尔，2-数字，3-数字范围，4-日期，5-日期范围，6-文本，7-列表',
        //    type; //项目类别 1 人资 2 患者 3药品 4诊断 5检查 6校验 7过敏史
        Patients rz = new Patients();
        rz.setItemName("I级手术资质");
        rz.setKlgItemValueType(6);
        rz.setType(1);
        rz.setEndValue("TEST_CODE_I");
        rz.setEndOp("==");
        patientss.add(rz);
        //TODO  最外层的比较符,  1是与 0是或
        rz.setRootCompare(1);
        Patients rz1 = new Patients();
        rz1.setItemName("IV级手术资质");
        rz1.setKlgItemValueType(6);
        rz1.setType(1);
        rz1.setEndValue("TEST_CODE_IV");
        rz1.setEndOp("==");
        patientss.add(rz1);


        Patients hz = new Patients();
        hz.setItemName("性别");
        hz.setKlgItemValueType(6);
        hz.setType(2);
        hz.setEndValue("男");
        hz.setEndOp("==");
        hz.setRootCompare(1);
        patientss.add(hz);

        Patients hz1 = new Patients();
        hz1.setItemName("年龄");
        hz1.setKlgItemValueType(2);
        hz1.setType(2);
        hz1.setStartValue("12");
        hz1.setStartOp(">= ");
        hz1.setEndValue("40");
        hz1.setEndOp("<= ");
        hz1.setRootCompare(0);
        patientss.add(hz1);

        Patients hz2 = new Patients();
        hz2.setItemName("是否医保");
        hz2.setKlgItemValueType(1);
        hz2.setType(2);
        hz2.setEndValue("true");
        hz2.setEndOp("==");
        patientss.add(hz2);

        Patients qt = new Patients();
        qt.setItemName("项目名称");
        qt.setKlgItemValueType(6);
        qt.setType(5);
        qt.setEndValue("腹泻");
        qt.setEndOp("==");
        qt.setRootCompare(1);//或
        patientss.add(qt);

        Patients qt1 = new Patients();
        qt1.setItemName("项目编码");
        qt1.setKlgItemValueType(6);
        qt1.setType(5);
        qt1.setEndValue("JY.001");
        qt1.setEndOp("==");
        qt1.setRootCompare(1);//或

        patientss.add(qt1);
        Patients qt2 = new Patients();
        qt2.setItemName("检验方法");
        qt2.setKlgItemValueType(6);
        qt2.setType(5);
        qt2.setStartValue("化学法");
        qt2.setStartOp("==");
        qt2.setRootCompare(0);//或
        patientss.add(qt2);
        return patientss;

    }

    public static String generateRules(List<Patients> patientss) throws PinyinException {

        StringBuilder result = new StringBuilder();
        /*package部分*/
        result.append("package com.jsg.drools;\r\n");
        result.append("\r\n");
        /*导包部分*/
        result.append("import com.jsg.entity.*;\r\n");
        result.append("import java.util.*;\r\n");
        result.append("import java.lang.*;\r\n");
        result.append("dialect \"java\";\r\n");
        result.append("\r\n");

        for (Patients patient : patientss) {
            String ruleName = PinyinHelper.convertToPinyinString(patient.getItemName(), "_", PinyinFormat.WITHOUT_TONE);
            String startValue = patient.getStartValue();
            String endValue = patient.getEndValue();
            //TODO 判断是否双条件
            //TODO 判断参数值的类型  klgItemValueType; 知识库属性值类型：1-布尔，2-数字，3-数字范围，4-日期，5-日期范围，6-文本，7-列表',
            Integer klgItemValueType = patient.getKlgItemValueType();

            if (startValue != null && endValue != null && klgItemValueType == 1) {
                result.append(strStar(result, ruleName));
                /*规则条件部分*/
                result.append("\twhen\r\n");
                result.append("\t\t" +
                        "patientObj:Patients(pinyin == \"" + ruleName + "\" && endValueBoo " + patient.getStartOp() + " " + startValue + " &&  endValueBoo" + patient.getEndOp() + " " + endValue + " );" +
                        "\r\n");
                strEnd(result);
            } else if (startValue != null && endValue != null && klgItemValueType == 2) {
                strStar(result, ruleName);
                /*规则条件部分*/
                result.append("\twhen\r\n");
                result.append("\t\t" +
                        "patientObj:Patients(pinyin == \"" + ruleName + "\" && endValueInt " + patient.getStartOp() + " " + startValue + " &&  endValueInt" + patient.getEndOp() + " " + endValue + " );" +
                        "\r\n");
                strEnd(result);

            } else if (startValue != null && endValue != null && klgItemValueType == 3) {
                strStar(result, ruleName);
                /*规则条件部分*/
                result.append("\twhen\r\n");
                result.append("\t\t" +
                        "patientObj:Patients(pinyin == \"" + ruleName + "\" && endValueInt " + patient.getStartOp() + " " + startValue + " &&  endValueInt" + patient.getEndOp() + " " + endValue + " );" +
                        "\r\n");
                strEnd(result);

            } else if (startValue != null && endValue != null && klgItemValueType == 4) {
                //TODO 暂无

            } else if (startValue != null && endValue != null && klgItemValueType == 5) {
                //TODO 暂无

            } else if (startValue != null && endValue != null && klgItemValueType == 6) {
                strStar(result, ruleName);
                /*规则条件部分*/
                result.append("\twhen\r\n");
                result.append("\t\t" +
                        "patientObj:Patients(pinyin == \"" + ruleName + "\" && endValue  " + patient.getStartOp() + "\" " + startValue + "\" &&  endValue" + patient.getEndOp() + " \"" + endValue + "\" );" +
                        "\r\n");
                strEnd(result);
            } else if (startValue == null && endValue != null && klgItemValueType == 1) {
                strStar(result, ruleName);
                /*规则条件部分*/
                result.append("\twhen\r\n");
                result.append("\t\t" +
                        "patientObj:Patients(pinyin == \"" + ruleName + "\"  && endValueBoo" + patient.getEndOp() + " " + endValue + " );" +
                        "\r\n");
                strEnd(result);
            } else if (startValue == null && endValue != null && klgItemValueType == 2) {
                strStar(result, ruleName);
                /*规则条件部分*/
                result.append("\twhen\r\n");

                result.append("\t\t" +
                        "patientObj:Patients(pinyin == \"" + ruleName + "\"  && endValueInt" + patient.getEndOp() + " " + endValue + " );" +
                        "\r\n");
                strEnd(result);
            } else if (startValue == null && endValue != null && klgItemValueType == 3) {
                strStar(result, ruleName);
                /*规则条件部分*/
                result.append("\twhen\r\n");
                result.append("\t\t" +
                        "patientObj:Patients(pinyin == \"" + ruleName + "\"  && endValueInt" + patient.getEndOp() + " " + endValue + " );" +
                        "\r\n");
                strEnd(result);
            } else if (startValue == null && endValue != null && klgItemValueType == 4) {
                //TODO 暂无

            } else if (startValue == null && endValue != null && klgItemValueType == 5) {
                //TODO 暂无

            } else if (startValue == null && endValue != null && klgItemValueType == 6) {
                strStar(result, ruleName);
                /*规则条件部分*/
                result.append("\twhen\r\n");
                result.append("\t\t" +
                        "patientObj:Patients(pinyin == \"" + ruleName + "\"  &&  endValue" + patient.getEndOp() + "\" " + endValue + "\" );" +
                        "\r\n");

                strEnd(result);
            }

        }
        String s = result.toString();
        System.out.println(s);

        return s;
    }


    private static StringBuilder strStar(StringBuilder result, String ruleName) {
        /*规则申明部分*/
        result.append("rule \"" + ruleName + "\"\r\n");
        /*规则属性部分*/
        //TODO  不可重复执行
        result.append("\tno-loop true \r\n");
        return result;

    }


    private static StringBuilder strEnd(StringBuilder result) {
        /*规则结果部分*/
        result.append("\tthen\r\n");
        result.append("\t\tpatientObj.setResult(true);\r\n");
        result.append("\t\tSystem.out.println(\"The rule's name is '\" + drools.getRule().getName() + \"'\");\r\n");
        /*规则结束*/
        result.append("end\r\n");
        result.append("\r\n");
        return result;

    }
}
