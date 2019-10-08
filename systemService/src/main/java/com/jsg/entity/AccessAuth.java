package com.jsg.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author jeanson 进生
 * @date 2019/10/8 20:05
 */
@Data
public class AccessAuth {
    private Integer id;
    private String appName;
    private String appCode;
    private String authKey;
    private String authIpList;
    private Integer isExpired;
    private Date expiredDate;
    private Integer status;
    private Date createTime;
    private Date updateTime;
    private Integer createUserId;
    private Integer updateUserId;
}
