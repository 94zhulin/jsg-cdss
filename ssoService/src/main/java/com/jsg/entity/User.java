package com.jsg.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author jeanson 进生
 * @date 2019/10/26 23:51
 */
@Data
public class User {
    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 医生编码
     */
    private String ysCode;

    /**
     * 科室编码
     */
    private String ksCode;

    /**
     * 姓名
     */
    private String fullName;

    /**
     * 性别：1-男；2-女；0-不详
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 手机号
     */
    private String mobileNum;

    /**
     * 职务
     */
    private String jobTitle;

    /**
     * 状态：0-停用；1-启用
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private Integer createUserid;

    /**
     * 修改人
     */
    private Integer updateUserid;

    /**
     * 最近登录时间
     */
    private Date lastLoginTime;

    /**
     * 最近登录IP
     */
    private String lastLoginIp;

    private  Role role ;

}