package com.example.mybatis_demo;

import com.example.mybatis_demo.dao.UserDao;
import com.example.mybatis_demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisDemoApplicationTests {
    @Autowired
    UserDao userDao;

    @Test
    void test() {
        User user = userDao.getById(7L);
        System.out.println(user.toString());
    }
}
