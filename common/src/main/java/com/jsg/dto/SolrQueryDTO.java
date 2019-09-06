package com.jsg.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SolrQueryDTO implements Serializable {
    private String keyName;
    private String keyVal;
}
