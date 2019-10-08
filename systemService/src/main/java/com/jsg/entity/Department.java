package com.jsg.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author jeanson 进生
 * @date 2019/10/8 20:08
 */
@Data
public class Department {
    private Integer id;
    private Integer hospitalId;
    private Date statTime;
    private String ksCode;
    private String ksName;
    private Integer ksType;
}
