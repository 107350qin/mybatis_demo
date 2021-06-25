package com.example.mybatis_demo.mybatis;

import com.example.mybatis_demo.mybatis.entity.User;
import com.example.mybatis_demo.mybatis.mapper.UserMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class WebDemo {
    @Resource
    UserMapper userMapper;
    @RequestMapping("/get")
    public Object get(){
        User user=userMapper.selectById("1");
        return user;
    }
}
