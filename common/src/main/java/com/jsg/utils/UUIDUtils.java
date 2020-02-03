package com.jsg.utils;

import java.util.UUID;

/**
 * @Auther: wyx
 * @Date: 2019-04-08 10:09
 * @Description:
 */
public class UUIDUtils {

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

}
