package com.jsg.entity.mysql;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

import java.io.Serializable;

@JsonInclude(Include.NON_NULL)
@Data
public class HzxxMdm implements Serializable {
    private static final long serialVersionUID = -4942604146741416443L;
    private Integer id;// 唯一性ID
    private String CJGZRQ;// 参加工作日期
    private String CSD;// 出生地
}
