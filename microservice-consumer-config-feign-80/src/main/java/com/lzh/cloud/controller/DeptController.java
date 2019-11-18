package com.lzh.cloud.controller;

import com.lzh.cloud.model.Dept;
import com.lzh.cloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lzh
 * create 2019-11-05-11:28
 */
@RestController
public class DeptController {

    @Autowired
    private DeptClientService service;

    @GetMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @GetMapping("/consumer/dept/list")
    public List<Dept> list() {
        return service.list();
    }

    @GetMapping("/consumer/dept/add")
    public Object add(Dept dept) {
        return service.add(dept);
    }

}
