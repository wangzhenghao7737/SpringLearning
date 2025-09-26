package com.openapi.springdoc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.openapi.springdoc.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author D14
* @description 针对表【user(用户表)】的数据库操作Mapper
* @createDate 2025-09-26 18:36:49
* @Entity generator.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

    User login(@Param("username") String username);
}




