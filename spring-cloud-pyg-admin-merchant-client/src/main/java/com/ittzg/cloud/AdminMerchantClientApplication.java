package com.ittzg.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: ittzg
 * @CreateDate: 2019/1/26 17:17
 * @Description: 商家运营平台
 */
@SpringBootApplication
public class AdminMerchantClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminMerchantClientApplication.class,args);
    }
}
