package com.example.mybatis_demo.entity;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String userDesc;
    private String username;
    private String password;
}