package com.jk.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.jk.*")
@MapperScan("com.jk.mapper")
public class SsmMyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsmMyApplication.class, args);
    }

}

