package com.jsg.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author jeanson 进生
 * @date 2019/10/8 20:11
 */
@Data
public class DictionaryCatalog {
    private Integer id;
    private Integer parentId;
    private String name;
    private String code;
    private Integer childNum;
    private Integer dictNum;
    private Integer status;
    private Date createTime;
    private Date updateTime;
    private Integer createUserId;
    private Integer updateUserId;
}
