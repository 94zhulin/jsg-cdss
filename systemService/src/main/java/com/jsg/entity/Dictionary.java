package com.jsg.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author jeanson 进生
 * @date 2019/10/8 20:10
 */
@Data
public class Dictionary {
    private Integer id;
    private Integer catalogId;
    private String name;
    private String code;
    private Date createTime;
    private Date updateTime;
    private Integer createUserId;
    private Integer updateUserId;
}
