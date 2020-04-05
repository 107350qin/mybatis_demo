package com.example.mybatis_demo.dao;

import com.example.mybatis_demo.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User getById(Long id);
}
