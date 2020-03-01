package com.jsg.utils;


import com.jsg.entity.Patients;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jeanson 进生
 * @date 2020/1/9 15:01
 */
public class ReflectionUtils {
    /**
     * 得到属性值
     *
     * @param obj
     */
    public static List<Patients> readAttributeValue(Object obj) {
        List<Patients> datas = new ArrayList<>();
        //得到class
        Class cls = obj.getClass();
        //得到所有属性
        Field[] fields = cls.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {//遍历
            Patients patient = new Patients();
            try {
                //得到属性
                Field field = fields[i];
                //打开私有访问
                field.setAccessible(true);
                //获取属性值
                Object param = field.get(obj);
                if (param != null) {
                    String name = field.getName();
                    //获取属性
                    patient.setName(name);
                    if (param instanceof Integer) {
                        int value = ((Integer) param).intValue();
                        patient.setEndValueNumerical(value);
                    } else if (param instanceof String) {
                        String s = (String) param;
                        patient.setEndValue(s);
                    } else if (param instanceof Double) {
                        double d = ((Double) param).doubleValue();
                        patient.setEndValueNumerical(d);
                    } else if (param instanceof Float) {
                        float f = ((Float) param).floatValue();
                        Float aFloat = Float.valueOf(f);
                        Double aDouble = Double.valueOf(aFloat);
                        patient.setEndValueNumerical(aDouble);
                    } else if (param instanceof Long) {
                        long l = ((Long) param).longValue();
                        Double aDouble = Double.valueOf((l + ""));
                        patient.setEndValueNumerical(aDouble);
                    } else if (param instanceof Boolean) {
                        boolean b = ((Boolean) param).booleanValue();
                        patient.setEndValueBoo(b);
                    } else if (param instanceof Date) {
                        Date d = (Date) param;
                        patient.setEndValueDate(d);
                    } else if (param instanceof List) {
                        List list = (List) param;
                        patient.setEndValueList(list);
                    }
                    datas.add(patient);
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return datas;
    }

}
