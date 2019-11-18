package com.lzh.cloud.controller;

import com.lzh.cloud.model.Dept;
import com.lzh.cloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lzh
 * create 2019-11-05-9:39
 */
@RestController
public class DeptController_Consumer {

    @Autowired
    DeptService deptService;

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept) {
        return deptService.add(dept);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable Long id) {
        return deptService.get(id);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list() {
        return deptService.list();
    }

    // 测试@EnableDiscoveryClient,消费端可以调用服务发现
    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery() {
        return deptService.discovery();
    }

}
