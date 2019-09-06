package com.jsg.enums;

/**
 * @author Dean(段鬻)
 * @createTime 2018/8/29 19:34 消息状态枚举类
 */
public enum TaskStatus {
    RUNNING(1, "执行中"), FINISHED(9, "已完成"), ERROR(-1, "执行异常");

    private final int key;
    private final String value;

    TaskStatus(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public static TaskStatus getEnumByKey(int key) {
        if (key < 1 || key > 4) {
            return null;
        }
        for (TaskStatus temp : TaskStatus.values()) {
            if (temp.getKey() == key) {
                return temp;
            }
        }
        return null;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}