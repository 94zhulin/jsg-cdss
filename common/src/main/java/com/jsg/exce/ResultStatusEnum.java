package com.jsg.exce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 响应结果状态枚举类
 *
 * @author MoCha
 * @date 2019/5/25
 */
@NoArgsConstructor
@AllArgsConstructor
public enum ResultStatusEnum {
    /**
     * 请求成功
     */
    SUCCESS(200, "请求成功！"),

    /**
     * 密码错误
     */
    ABNORMAL_PERMISSIONS(999, "暂无权限,请联系管理人员");


    @Getter
    @Setter
    private int code;

    @Getter
    @Setter
    private String message;
}
