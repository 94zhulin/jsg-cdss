package com.jsg.base.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

import java.io.Serializable;

/**
 * Restful API返回值定义
 *
 * @author weidong
 * @date 2018/7/24
 */
@JsonInclude(Include.NON_NULL)
@Data
public class ResultBase<T> implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -3018692804320692301L;

    // 999 失败，用户逻辑错误，用户将msg直接返回给用户
    // 500 系统异常，msg返回系统异常
    // 200 成功，data返回结果
    private Integer status;

    private String msg;

    // content 返回体报文的出参，使用泛型兼容不同的类型
    private T data;

}
