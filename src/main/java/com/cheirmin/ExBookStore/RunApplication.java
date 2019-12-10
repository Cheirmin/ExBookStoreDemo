package com.cheirmin.ExBookStore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Message:
 * @Author：Cheirmin
 * @Date: 2019/11/30 11:55
 * @Version 1.0
 */
@MapperScan("com.cheirmin.ExBookStore.dao")
@SpringBootApplication
public class RunApplication {
    public static void main(String[] args) {
        SpringApplication.run(RunApplication.class,args);
    }
}
