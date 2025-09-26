package com.openapi.springdoc.response.enums;

public enum SystemCodeEnum {
    SYSTEM_ERROR(1001,"system error"),
    DATA_BASE_ERROR(1002,"database error");
    private int code;
    private String message;
    SystemCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
