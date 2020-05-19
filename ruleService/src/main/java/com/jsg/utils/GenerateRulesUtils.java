package com.jsg.utils;

import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.jsg.entity.Patients;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/12/20 23:00
 */
public class GenerateRulesUtils {



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
        result.append("global java.util.HashMap resultHashMap ;\r\n");
        result.append("\r\n");

        for (int s = 0; s < patientss.size(); s++) {
            System.out.println(result.toString());
            Patients patient = patientss.get(s);
            Integer rootCompare = patient.getRootCompare();
            String ruleName = PinyinHelper.convertToPinyinString(patient.getKlgItemName(), "_", PinyinFormat.WITHOUT_TONE);
          //  String name = patient.getKlgItemName();
            String name = patient.getKlgItemPropName();
            //   patient.setPinyin(name);
            String startValue = patient.getStartValue();
            String endValue = patient.getEndValue();
            boolean isOr = false;
            //TODO 获取类型 项目类别 1 人资 2 患者 3药品 4诊断 5检查 6校验 7过敏史
            Integer type = patient.getConditionType();
            //TODO 目前支持 上下5个or 的语句
            StringBuilder isOrRuleName = new StringBuilder();

            //TODO  针对患者信息,患者属性信息比较复杂

            if (2==type){
                //TODO  A==A or B=B  ， rootCompare一般都是开头的条件才会是 rootCompare==null
                if (rootCompare == null){
                    //TODO 开始往下循环， 查询到有没有or条件， 遇到 and 条件结束循环
                    for (int i = s;i<patientss.size();i++){
                        int  index = i+1;
                        Patients patients = patientss.get(index);
                        Integer rootCompare_one = patients.getRootCompare();
                        Integer conditionType = patients.getConditionType();
                        //TODO 判断是否 为 or条件 ,并且共同是患者 属性
                        if (rootCompare_one==0 && conditionType==2){
                            //TODO  获取这个条件的规则名称
                            String s1 = PinyinHelper.convertToPinyinString(patients.getKlgItemName(), "_", PinyinFormat.WITHOUT_TONE);
                            isOrRuleName.append("\t\tresultHashMap.put(\"" + s1 + "\",true);\r\n");
                            isOr = true;

                         //TODO 遇到 and 就马上结束循环。
                        }else {
                            break;
                        }
                    }

                    //TODO   rootCompare 不为null ， 有可能是 or ，and，有点复杂
                }else {
                    //TODO 如果当前是 and，那么 往下循环走  性别 （与年龄） （与性别）
                    if (rootCompare==1){
                        //TODO 开始往下循环， 查询到有没有or条件， 遇到 and 条件结束循环
                        for (int i = s;i<patientss.size();i++){
                            int  index = i+1;
                            Patients patients = patientss.get(index);
                            Integer rootCompare_one = patients.getRootCompare();
                            Integer conditionType = patients.getConditionType();
                            //TODO 判断是否 为 or条件 ,并且共同是患者 属性
                            if (rootCompare_one==0 && conditionType==2){
                                //TODO  获取这个条件的规则名称
                                String s1 = PinyinHelper.convertToPinyinString(patients.getKlgItemName(), "_", PinyinFormat.WITHOUT_TONE);
                                isOrRuleName.append("\t\tresultHashMap.put(\"" + s1 + "\",true);\r\n");
                                isOr = true;

                                //TODO 遇到 and 就马上结束循环。
                            }else {
                                break;
                            }
                        }
                    }else {
                        //TODO 如果当前是 or，那么 往下循环走  性别 （or年龄） （or性别）
                        for (int i = s;i<patientss.size();i++){
                            int  index = i+1;
                            Patients patients = patientss.get(index);
                            Integer rootCompare_one = patients.getRootCompare();
                            Integer conditionType = patients.getConditionType();
                            //TODO 判断是否 为 or条件 ,并且共同是患者 属性
                            if (rootCompare_one==0 && conditionType==2){
                                //TODO  获取这个条件的规则名称
                                String s1 = PinyinHelper.convertToPinyinString(patients.getKlgItemName(), "_", PinyinFormat.WITHOUT_TONE);
                                isOrRuleName.append("\t\tresultHashMap.put(\"" + s1 + "\",true);\r\n");
                                isOr = true;

                                //TODO 遇到 and 就马上结束循环。
                            }else {
                                break;
                            }
                        }

                        //TODO 如果当前是 or，那么 往下循环走  性别 （or年龄） （or性别）
                        for (int i = s-1;i<s;i--){
                            if(i>-1){
                                Patients patients = patientss.get(i);
                                Integer rootCompare_one = patients.getRootCompare();
                                Integer conditionType = patients.getConditionType();
                                //TODO 判断是否 为 or条件 ,并且共同是患者 属性
                                if (rootCompare_one==0 && conditionType==2){
                                    //TODO  获取这个条件的规则名称
                                    String s1 = PinyinHelper.convertToPinyinString(patients.getKlgItemName(), "_", PinyinFormat.WITHOUT_TONE);
                                    isOrRuleName.append("\t\tresultHashMap.put(\"" + s1 + "\",true);\r\n");
                                    isOr = true;

                                    //TODO 遇到 and 就马上结束循环。
                                }else {
                                    //TODO  获取这个条件的规则名称
                                    String s1 = PinyinHelper.convertToPinyinString(patients.getKlgItemName(), "_", PinyinFormat.WITHOUT_TONE);
                                    isOrRuleName.append("\t\tresultHashMap.put(\"" + s1 + "\",true);\r\n");
                                    isOr = true;
                                    break;
                                }
                            }
                        }
                    }
                }

              //TODO    4诊断 5检查 6校验
            }/*else  if (type == 4 || type == 5 || type == 6){
                //TODO  获取这个条件的规则名称
                String s1 = PinyinHelper.convertToPinyinString(patients.getKlgItemName(), "_", PinyinFormat.WITHOUT_TONE);
                isOrRuleName.append("\t\tresultHashMap.put(\"" + s1 + "\",true);\r\n");
                isOr = true;

            }*/



            //TODO 判断是否双条件
            //TODO 判断参数值的类型  klgItemValueType; 知识库属性值类型：1-布尔，2-数字，3-数字范围，4-日期，5-日期范围，6-文本，7-列表',
            Integer klgItemValueType = patient.getKlgItemValueType();

            if (startValue != null && endValue != null && klgItemValueType == 1) {
                strStar(result, ruleName);
                //规则条件部分
                result.append("\twhen\r\n");
                result.append("\t\t" +
                        "patientObj:Patients(name == \"" + name + "\" && endValueBoo " + patient.getStartOp() + " " + startValue + " &&  endValueBoo" + patient.getEndOp() + " " + endValue + " );" +
                        "\r\n");
                strEnd(result, isOrRuleName, isOr);
            } else if (startValue != null && endValue != null && klgItemValueType == 2) {
                strStar(result, ruleName);
                //  规则条件部分
                result.append("\twhen\r\n");
                result.append("\t\t" +
                        "patientObj:Patients(name == \"" + name + "\" && endValueNumerical " + patient.getStartOp() + " " + startValue + " &&  endValueNumerical" + patient.getEndOp() + " " + endValue + " );" +
                        "\r\n");
                strEnd(result, isOrRuleName, isOr);

            } else if (startValue != null && endValue != null && klgItemValueType == 3) {
                strStar(result, ruleName);
                //  规则条件部分
                result.append("\twhen\r\n");
                result.append("\t\t" +
                        "patientObj:Patients(name == \"" + name + "\" && endValueNumerical " + patient.getStartOp() + " " + startValue + " &&  endValueNumerical" + patient.getEndOp() + " " + endValue + " );" +
                        "\r\n");
                strEnd(result, isOrRuleName, isOr);

            } else if (startValue != null && endValue != null && klgItemValueType == 4) {
                //TODO 暂无

            } else if (startValue != null && endValue != null && klgItemValueType == 5) {
                //TODO 暂无

            } else if (startValue != null && endValue != null && klgItemValueType == 6) {
                strStar(result, ruleName);
                // 规则条件部分
                result.append("\twhen\r\n");
                result.append("\t\t" +
                        "patientObj:Patients(name == \"" + name + "\" && endValue  " + patient.getStartOp() + "\"" + startValue + "\" &&  endValue" + patient.getEndOp() + " \"" + endValue + "\" );" +
                        "\r\n");
                strEnd(result, isOrRuleName, isOr);
            } else if (startValue == null && endValue != null && klgItemValueType == 1) {
                strStar(result, ruleName);
                //  规则条件部分
                result.append("\twhen\r\n");
                result.append("\t\t" +
                        "patientObj:Patients(name == \"" + name + "\"  && endValueBoo" + patient.getEndOp() + " " + endValue + " );" +
                        "\r\n");
                strEnd(result, isOrRuleName, isOr);
            } else if (startValue == null && endValue != null && klgItemValueType == 2) {
                strStar(result, ruleName);
                //   规则条件部分
                result.append("\twhen\r\n");

                result.append("\t\t" +
                        "patientObj:Patients(name == \"" + name + "\"  && endValueNumerical" + patient.getEndOp() + " " + endValue + " );" +
                        "\r\n");
                strEnd(result, isOrRuleName, isOr);
            } else if (startValue == null && endValue != null && klgItemValueType == 3) {
                strStar(result, ruleName);
                //   规则条件部分
                result.append("\twhen\r\n");
                result.append("\t\t" +
                        "patientObj:Patients(name == \"" + name + "\"  && endValueNumerical" + patient.getEndOp() + " " + endValue + " );" +
                        "\r\n");
                strEnd(result, isOrRuleName, isOr);
            } else if (startValue == null && endValue != null && klgItemValueType == 4) {
                //TODO 暂无

            } else if (startValue == null && endValue != null && klgItemValueType == 5) {
                //TODO 暂无

            } else if (startValue == null && endValue != null && klgItemValueType == 6) {
                strStar(result, ruleName);
                // 规则条件部分
                result.append("\twhen\r\n");
                result.append("\t\t" +
                        "patientObj:Patients(name == \"" + name + "\"  &&  endValue" + patient.getEndOp() + "\"" + endValue + "\" );" +
                        "\r\n");

                strEnd(result, isOrRuleName, isOr);
            }

        }
        String s = result.toString();
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


    private static StringBuilder strEnd(StringBuilder result, StringBuilder RuleName, Boolean isOr) {
        /*规则结果部分*/
        result.append("\tthen\r\n");
        if (isOr) {
            result.append(RuleName);
        }
        result.append("\t\tresultHashMap.put(drools.getRule().getName(),true);\r\n");
        result.append("\t\tSystem.out.println(\"The rule's name is '\" + drools.getRule().getName() + \"'\");\r\n");
        /*规则结束*/
        result.append("end\r\n");
        result.append("\r\n");
        return result;

    }
}
