package com.jsg.entity.sqlserver;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

import java.io.Serializable;

@JsonInclude(Include.NON_NULL)
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -5085790666668185889L;
    private Integer id;// 唯一性ID
    private String name;// 姓名
}
