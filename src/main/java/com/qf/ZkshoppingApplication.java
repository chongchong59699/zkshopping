package com.qf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
// 启用事务
@EnableTransactionManagement
@MapperScan("com.qf.dao")
public class ZkshoppingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZkshoppingApplication.class, args);
    }

}
