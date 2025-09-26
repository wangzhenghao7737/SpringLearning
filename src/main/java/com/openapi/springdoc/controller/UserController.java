package com.openapi.springdoc.controller;

import cn.hutool.core.util.ObjectUtil;
import com.openapi.springdoc.annotation.ApiLog;
import com.openapi.springdoc.expection.BusinessException;
import com.openapi.springdoc.model.DTO.LoginUser;
import com.openapi.springdoc.model.entity.User;
import com.openapi.springdoc.response.BaseResponse;
import com.openapi.springdoc.response.enums.BusinessCodeEnum;
import com.openapi.springdoc.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "user interface",description = "users' api")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiLog("表单登录")
    @Operation(summary = "login with form")
    @PostMapping("/loginForm")
    public String UserLogin(@RequestParam String username, @RequestParam String password) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(username);
        stringBuilder.append(password);
        return stringBuilder.toString();
    }

    @ApiLog("user login")
    @Operation(summary = "login json")
    @PostMapping("/login")
    public BaseResponse<User> UserLoginJSON(@RequestBody LoginUser loginUser) {
        if (ObjectUtil.isEmpty(loginUser) || ObjectUtil.isEmpty(loginUser.getUsername()) || ObjectUtil.isEmpty(loginUser.getPassword())) {
            throw new BusinessException(BusinessCodeEnum.LOGIN_INFO_MISSING);
        }
        return BaseResponse.success(BusinessCodeEnum.LOGIN_SUCCESS,userService.login(loginUser));
    }

    @ApiLog("get user by userId")
    @Operation(summary = "get user by id")
    @GetMapping("/getUser/{id}")
    public BaseResponse<User> getUserById(@PathVariable Long id) {
        User byUserId = userService.getByUserId(id);
        if(ObjectUtil.isEmpty(byUserId)){
            throw new BusinessException(BusinessCodeEnum.USER_NOT_FOUND);
        }
        return BaseResponse.success(BusinessCodeEnum.SUCCESS,byUserId);
    }
}
