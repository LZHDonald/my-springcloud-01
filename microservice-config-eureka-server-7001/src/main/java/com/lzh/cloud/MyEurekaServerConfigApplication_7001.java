package com.lzh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author lzh
 * create 2019-11-03-21:58
 */
//EurekaServer服务器端启动类,接受其它微服务注册进来
@EnableEurekaServer
@SpringBootApplication
public class MyEurekaServerConfigApplication_7001 {
    public static void main(String[] args) {
        SpringApplication.run(MyEurekaServerConfigApplication_7001.class);
    }
}
