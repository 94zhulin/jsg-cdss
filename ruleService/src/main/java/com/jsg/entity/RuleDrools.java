package com.jsg.entity;

import lombok.Data;

import java.util.Date;

/**
 * rule_drools
 *
 * @author
 */
@Data
public class RuleDrools {
    private Integer id;

    private Integer ruleBaseid;

    private String name;

    private String code;

    /**
     * 决策类型：1-拦截；2-警告；3-建议；
     */
    private Integer policyType;

    private Integer version;

    /**
     * 0 停用 1启用
     */
    private Integer status;

    private String str;
    private Integer count;
    private String feedback;
    private Date createTime;

    private Date updateTime;

    private Integer createUserId;

    private Integer updateUserid;

}