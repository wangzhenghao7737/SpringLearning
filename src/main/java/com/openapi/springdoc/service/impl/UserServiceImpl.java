package com.openapi.springdoc.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.openapi.springdoc.expection.BusinessException;
import com.openapi.springdoc.mapper.UserMapper;

import com.openapi.springdoc.model.DTO.LoginUser;
import com.openapi.springdoc.model.entity.User;
import com.openapi.springdoc.response.enums.BusinessCodeEnum;
import com.openapi.springdoc.service.UserService;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
* @author D14
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2025-09-26 18:36:49
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public User getByUserId(Long id) {
        User user = userMapper.selectById(id);

        return user;
    }

    @Override
    public User login(LoginUser loginUser) {
        User user = userMapper.login(loginUser.getUsername());
        if (ObjectUtil.isNull(user)){
            throw new BusinessException(BusinessCodeEnum.USER_NOT_FOUND);
        }
        if (ObjectUtil.notEqual(loginUser.getPassword(), user.getPassword())){
            throw new BusinessException(BusinessCodeEnum.USER_PWD_ERROR);
        }
        if (ObjectUtil.equal(user.getStatus(),0)){
            throw new BusinessException(BusinessCodeEnum.USER_FREEZE);
        }
        return user;
    }
}




