package com.ittzg.cloud;

import com.sun.glass.ui.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: ittzg
 * @CreateDate: 2019/1/26 14:48
 * @Description:
 */
@SpringBootApplication
@EnableEurekaServer
public class PygDiscoverEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(PygDiscoverEurekaApplication.class,args);
    }
}
