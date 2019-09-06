package com.jsg.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1368231423424241621L;
    private Integer id;
    private String name;
}
