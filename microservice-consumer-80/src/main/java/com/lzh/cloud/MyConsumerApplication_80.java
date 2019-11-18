package com.lzh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * @author lzh
 * create 2019-11-04-22:26
 */
@SpringBootApplication
@EnableEurekaClient
//自定义负载均衡规则
//在启动该为服务的时候就能去加载我们的自定义Ribbon配置类，从而使配置生效
//configuration = MySelfRule.class  把MySelfRule配置类加载进容器
//@RibbonClient(name = "MICROSERVICECLOUD-DEPT",configuration = MySelfRule.class)
@EnableDiscoveryClient
public class MyConsumerApplication_80 {
    public static void main(String[] args) {
        SpringApplication.run(MyConsumerApplication_80.class);
    }
}
