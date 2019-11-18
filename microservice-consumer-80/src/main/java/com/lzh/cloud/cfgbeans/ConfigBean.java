package com.lzh.cloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lzh
 * create 2019-11-05-9:58
 */
@Configuration
public class ConfigBean {

    @Bean
    //加入负载均衡
    //Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端    负载均衡的工具
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
