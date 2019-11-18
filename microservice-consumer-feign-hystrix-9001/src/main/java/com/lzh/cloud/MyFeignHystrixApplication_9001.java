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
//启动hystrix对应用监控（所有提供者都需要添加spring boot的actuator依赖对应用监控）
@EnableHystrixDashboard
public class MyFeignHystrixApplication_9001 {
    public static void main(String[] args) {
        SpringApplication.run(MyFeignHystrixApplication_9001.class);
    }
}
