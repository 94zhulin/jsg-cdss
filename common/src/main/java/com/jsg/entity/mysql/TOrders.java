package com.jsg.entity.mysql;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@JsonInclude(Include.NON_NULL)
@Data
public class TOrders implements Serializable {
    private static final long serialVersionUID = 1849550086948521056L;
    private Integer id;
    private String orderNum;
    private Date createTime;
}
