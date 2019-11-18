package com.lzh.cloud.service;

import com.lzh.cloud.model.Dept;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lzh
 * create 2019-11-05-11:31
 */
//@FeignClient(value = "MICROSERVICECLOUD-DEPT")
//fallbackFactory添加服务降级
@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory=DeptClientServiceFallbackFactory.class)
public interface DeptClientService {


    @GetMapping("/dept/get/{id}")
    Dept get(@PathVariable("id") long id);

    @GetMapping("/dept/list")
    List<Dept> list();

    @PostMapping("/dept/add")
    boolean add(Dept dept);
}