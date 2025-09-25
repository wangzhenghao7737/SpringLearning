package com.openapi.springdoc.controller;

import com.openapi.springdoc.annotation.ApiLog;
import com.openapi.springdoc.model.DTO.LoginUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "user interface",description = "users' api")
@RestController
@RequestMapping("/user")
public class UserController {

    @ApiLog("表单登录")
    @Operation(summary = "login with form")
    @PostMapping("/loginForm")
    public String UserLogin(@RequestParam String username, @RequestParam String password) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(username);
        stringBuilder.append(password);
        return stringBuilder.toString();
    }

    @ApiLog("登录")
    @Operation(summary = "login json")
    @PostMapping("/loginJSON")
    public String UserLoginJSON(@RequestBody LoginUser loginUser) {
        System.out.println(loginUser.getUsername());
        return loginUser.toString();
    }
}
