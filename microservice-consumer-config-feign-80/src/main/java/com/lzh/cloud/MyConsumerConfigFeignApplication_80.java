package com.lzh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lzh
 * create 2019-11-05-11:27
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MyConsumerConfigFeignApplication_80 {
    public static void main(String[] args) {
        SpringApplication.run(MyConsumerConfigFeignApplication_80.class);
    }
}
