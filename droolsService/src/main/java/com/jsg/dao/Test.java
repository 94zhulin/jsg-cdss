package com.jsg.dao;

/**
 * @author jeanson 进生
 * @date 2019/12/19 14:57
 */
public class Test {
    public static void main(String[] args) {
        String tiem = "09:00"  ;
        String[] split = tiem.split(";");
        for (String  s :split){
            System.out.println(s);
        }

    }
}
