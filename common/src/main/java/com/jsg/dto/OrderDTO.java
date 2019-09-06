package com.jsg.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderDTO implements Serializable {
    private static final long serialVersionUID = -3225650499596073783L;
    private Integer id;
    private String orderNum;
}
