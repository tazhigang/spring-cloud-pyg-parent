package com.ittzg.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: ittzg
 * @CreateDate: 2019/1/26 14:40
 * @Description: 运营商管理平台
 */
@SpringBootApplication
public class AdminOperatorClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminOperatorClientApplication.class,args);
    }
}
