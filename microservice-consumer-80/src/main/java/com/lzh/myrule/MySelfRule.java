package com.lzh.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lzh
 * create 2019-05-19-17:10
 */

@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        //return new RandomRule(); //Ribbon默认是轮询，我自定义为随机
        //return new RoundRobinRule(); //Ribbon默认是轮询，我自定义为随机

        return new RandomRule_LZH(); // 我自定义为每台机器5次
    }

}
