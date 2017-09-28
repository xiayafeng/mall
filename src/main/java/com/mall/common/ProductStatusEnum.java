package com.mall.common;

/**
 * Created by peter on 17/9/28.
 */
public enum ProductStatusEnum {
    ON_SAVE(1, "在线");


    private int code;
    private String value;

    ProductStatusEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
