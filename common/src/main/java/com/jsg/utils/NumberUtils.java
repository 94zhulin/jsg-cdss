package com.jsg.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NumberUtils {
    private static final Logger logger = LoggerFactory.getLogger(NumberUtils.class);

    /**
     * Integer转Double
     *
     * @return
     */
    public static Double parseInteger2Double(Integer num) {
        return Double.parseDouble(Integer.toString(num));
    }
}
