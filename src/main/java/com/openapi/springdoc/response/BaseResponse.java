package com.openapi.springdoc.response;

import com.openapi.springdoc.response.enums.BusinessCodeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Schema(description = "通用响应体")
public class BaseResponse<T> {
    private Integer code;
    private String message;
    private T data;

    public BaseResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    //成功，默认success
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<T>(BusinessCodeEnum.SUCCESS.getCode(), BusinessCodeEnum.SUCCESS.getMessage(), data);
    }
    public static <T> BaseResponse<T> success(BusinessCodeEnum businessCodeEnum, T data) {
        return new BaseResponse<T>(businessCodeEnum.getCode(), businessCodeEnum.getMessage(), data);
    }
    public static <T> BaseResponse<T> error(BusinessCodeEnum businessCodeEnum) {
        return new BaseResponse<T>(businessCodeEnum.getCode(), businessCodeEnum.getMessage(), null);
    }
}
