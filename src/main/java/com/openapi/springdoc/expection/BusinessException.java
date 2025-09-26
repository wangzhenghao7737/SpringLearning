package com.openapi.springdoc.expection;

import com.openapi.springdoc.response.enums.BusinessCodeEnum;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
    private final BusinessCodeEnum businessCodeEnum;
    private final String message;

    public BusinessException(BusinessCodeEnum businessCodeEnum){
        this.businessCodeEnum = businessCodeEnum;
        this.message = businessCodeEnum.getMessage();
    }
}
