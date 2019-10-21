package com.jsg.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author jeanson 进生
 * @date 2019/10/21 10:44
 */
@Data
public class RuleCatalog {
    /**
     * 规则类别ID
     */
    private Integer id;

    /**
     * 类别编码
     */
    private String code;
    /**
     * 父类别ID
     */
    private Integer parentId;

    /**
     * 类别名称
     */
    private String name;

    /**
     * 层级
     */
    private Integer level;

    /**
     * 排序索引
     */
    private Integer orderIndex;

    /**
     * 子类别数量
     */
    private Integer childNum;

    /**
     * 规则数量
     */
    private Integer ruleNum;

    /**
     * 状态：1-启用；0-停用
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

}