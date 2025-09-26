package com.openapi.springdoc.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.openapi.springdoc.model.DTO.LoginUser;
import com.openapi.springdoc.model.entity.User;
/**
* @author D14
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2025-09-26 18:36:49
*/
public interface UserService extends IService<User> {
    User getByUserId(Long id);
    User login(LoginUser loginUser);
}
