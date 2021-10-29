package com.wwj.mycloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.wwj.mycloud", "com.alibaba.cola" })
@MapperScan("com.wwj.mycloud.gatewayimpl.database")
public class MycloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(MycloudApplication.class, args);
    }

}
