package com.example.mybatis_demo;

import com.example.mybatis_demo.mybatis.SlowSqlPlugin;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@SpringBootApplication
public class MybatisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisDemoApplication.class, args);
    }
    @Bean
    public SlowSqlPlugin slowSqlPlugin() {
        SlowSqlPlugin slowSqlPlugin = new SlowSqlPlugin();
        Properties properties = new Properties();
        properties.setProperty("slowTime", "10");
        slowSqlPlugin.setProperties(properties);
        return slowSqlPlugin;
    }
}
