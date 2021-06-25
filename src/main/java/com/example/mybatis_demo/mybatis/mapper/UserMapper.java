package com.example.mybatis_demo.mybatis.mapper;

import com.example.mybatis_demo.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User selectById(String id);
}
