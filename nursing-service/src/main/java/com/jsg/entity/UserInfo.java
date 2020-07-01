package com.jsg.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 作者：zhuLin
 * 日期：2020-06-24 11:55:55
 * 备注：用户实体类
 */
@Data
@TableName("sys_module")
public class UserInfo {
    private int id;         //ID
    private String name;    //姓名
    private String code;    //密码
    private String level;
}
