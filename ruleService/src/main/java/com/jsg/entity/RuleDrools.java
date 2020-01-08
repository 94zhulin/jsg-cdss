package com.jsg.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * rule_drools
 * @author 
 */
public class RuleDrools implements Serializable {
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

    private Date createTime;

    private Date updateTime;

    private Integer createUserid;

    private Integer updateUserid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRuleBaseid() {
        return ruleBaseid;
    }

    public void setRuleBaseid(Integer ruleBaseid) {
        this.ruleBaseid = ruleBaseid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getPolicyType() {
        return policyType;
    }

    public void setPolicyType(Integer policyType) {
        this.policyType = policyType;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCreateUserid() {
        return createUserid;
    }

    public void setCreateUserid(Integer createUserid) {
        this.createUserid = createUserid;
    }

    public Integer getUpdateUserid() {
        return updateUserid;
    }

    public void setUpdateUserid(Integer updateUserid) {
        this.updateUserid = updateUserid;
    }
}