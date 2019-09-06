package com.jsg.entity.mysql;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@JsonInclude(Include.NON_NULL)
@Data
public class TFamily implements Serializable {
    private static final long serialVersionUID = 6903874119184988225L;
    private Integer id;
    private String name;
    private Integer age;
    private Date createTime;
}
