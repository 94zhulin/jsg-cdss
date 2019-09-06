package com.jsg.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BankDTO implements Serializable {
    private Integer userId;
    private Integer money;
    private String name;
}
