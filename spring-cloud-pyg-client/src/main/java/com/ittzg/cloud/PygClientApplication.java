package com.ittzg.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: ittzg
 * @CreateDate: 2019/1/26 17:28
 * @Description: 页面客户端
 */
@SpringBootApplication
public class PygClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(PygClientApplication.class,args);
    }
}
