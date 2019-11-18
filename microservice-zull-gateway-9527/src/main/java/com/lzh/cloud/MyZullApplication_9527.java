package com.lzh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author lzh
 * create 2019-05-24-10:33
 */
//访问1：http://localhost:9527/lzh/microservicecloud-dept/dept/get/1
//访问2：http://localhost:9527/lzh/mydept/dept/get/1
@SpringBootApplication
@EnableZuulProxy
public class MyZullApplication_9527 {
    public static void main(String[] args) {
        SpringApplication.run(MyZullApplication_9527.class, args);
    }
}
