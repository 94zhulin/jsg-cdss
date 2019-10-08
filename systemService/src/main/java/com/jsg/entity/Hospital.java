package com.jsg.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author jeanson 进生
 * @date 2019/10/8 20:21
 */
@Data
public class Hospital {

    private Integer id;
    private String name;
    private String code;
    private String logoUrl;
    private String contactPerson;
    private String contactPhoneNum;
    private String contactAddress;
    private Date createTime;
    private Date updateTime;
    private Integer createUserId;
    private Integer updateUserId;
}
