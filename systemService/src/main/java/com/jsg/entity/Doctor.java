package com.jsg.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author jeanson 进生
 * @date 2019/10/8 20:15
 */
@Data
public class Doctor {
    private Integer id;
    private Integer hospitalId;
    private Date statTime;
    private String ysCode;
    private String ysName;
    private String password;
    private String passwordMd5;
    private String ksCode;
    private Integer ysType;
    private String mobileNum;
    private String jobTitle;
    private Integer sex;
}
