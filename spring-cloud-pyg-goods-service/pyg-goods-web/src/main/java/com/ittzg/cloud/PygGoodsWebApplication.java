package com.ittzg.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: ittzg
 * @CreateDate: 2019/1/26 23:17
 * @Description: 商品模块启动类
 */
@SpringBootApplication
@EnableEurekaClient
public class PygGoodsWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(PygGoodsWebApplication.class,args);
    }
}