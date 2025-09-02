package com.hmall.trade;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients()
@MapperScan("com.hmall.user.mapper")
@SpringBootApplication
public class TradeApplication {
    public static void main(String[] args) {

        SpringApplication.run(TradeApplication.class, args);
    }
}
