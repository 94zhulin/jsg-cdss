package com.jsg.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class FamilyDTO implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private String createTime;
}
