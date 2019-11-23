package com.jsg.aop;

import java.lang.annotation.*;

/**
 * 数据源
 *
 * @Description: PermissionCheck
 * @EnglishName jeanSon
 * @authod 进生
 * @date 2019/11/18
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface PermissionCheck {

    //枚举
    String value();
}
