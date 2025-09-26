package com.openapi.springdoc.response.enums;

import lombok.Data;

public enum BusinessCodeEnum {
    SUCCESS(0, "success"),
    LOGIN_SUCCESS(0, "login success"),
    UPDATE_INFO_SUCCESS(0, "update info success"),
    LOGOUT_SUCCESS(0, "logout success"),

    //error
    USER_NOT_FOUND(1001,"user isn't exist"),
    USER_PWD_ERROR(2002,"password error"),
    LOGIN_INFO_MISSING(2003,"login info missing"),
    USER_FREEZE(2004,"user frozen"),
    SYSTEM_ERROR(500,"system busy");
    private final int code;
    private final String message;
    BusinessCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
