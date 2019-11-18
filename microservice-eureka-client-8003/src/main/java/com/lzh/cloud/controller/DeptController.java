package com.lzh.cloud.controller;

import com.lzh.cloud.model.Dept;
import com.lzh.cloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lzh
 * create 2019-11-04-21:41
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService service;
    @Autowired
    private DiscoveryClient client;

    @PostMapping("/dept/add")
    public boolean add(@RequestBody Dept dept) {
        return service.add(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> list() {
        return service.list();
    }

    @GetMapping("/dept/discovery")
    public Object discovery(){
        List<String> list = client.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }
}
