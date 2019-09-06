package com.jsg.entity.mysql;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

import java.io.Serializable;

@JsonInclude(Include.NON_NULL)
@Data
public class TBank implements Serializable {
    private static final long serialVersionUID = 6903874119184988225L;
    private Integer userId;
    private Integer money;
    private String csd;
}
