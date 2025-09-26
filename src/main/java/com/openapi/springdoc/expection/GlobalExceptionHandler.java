package com.openapi.springdoc.expection;

import com.openapi.springdoc.response.BaseResponse;
import com.openapi.springdoc.response.enums.BusinessCodeEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public BaseResponse<?> businessExceptionHandler(BusinessException businessException){
        return BaseResponse.error(businessException.getBusinessCodeEnum());
    }
    @ExceptionHandler(Exception.class)
    public BaseResponse<?> exceptionHandler(Exception ex){
        return BaseResponse.error(BusinessCodeEnum.SYSTEM_ERROR);
    }
}
