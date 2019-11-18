package com.lzh.cloud.controller;

import com.lzh.cloud.model.Dept;
import com.lzh.cloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lzh
 * create 2019-05-18-16:52
 */

@RestController
public class DeptController {

    @Autowired
    private DeptService service = null;
    @Autowired
    private DiscoveryClient client;

    @Value("${spring.profiles}")
    private String profiles;

    @GetMapping("/dept/get/{id}")
    //一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = this.service.get(id);
        if (null == dept) {
            throw new RuntimeException("该ID：" + id + "没有没有对应的信息");
        }
        return dept;
    }

    @HystrixCommand(fallbackMethod = "processHystrixAdd_Post")
    @PostMapping("/dept/add")
    public boolean add(@RequestBody Dept dept) {
        if (null == dept) {
            throw new RuntimeException("添加失败");
        }
        return service.add(dept);
    }

    @HystrixCommand(fallbackMethod = "processHystrixAll_Get")
    @GetMapping("/dept/list")
    public List<Dept> list() {
        List<Dept> list = service.list();
        if (null == list) {
            throw new RuntimeException("没有数据");
        }
        return list;
    }

    //-----------------------Config信息-------------------------------------------
    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServers;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public String getConfig() {
        String str = "applicationName: " + applicationName + "\t eurekaServers:" + eurekaServers + "\t port: " + port+"\t"+"profiles="+profiles;
        System.out.println("str: " + str);
        return str;
    }
    //-----------------------discovery信息-------------------------------------------
    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> list = client.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }

        return this.client;
    }

    //-----------------------熔断处理-------------------------------------------
    public Dept processHystrix_Get(@PathVariable("id") Long id) {
        return new Dept().setDeptno(id)
                .setDname("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand")
                .setDb_source("no this database in MySQL");
    }
    public String processHystrixAdd_Post(@PathVariable("id") Long id) {
        return "添加用户失败";
    }
    public String processHystrixAll_Get() {
        return "不存在任何信息";
    }
}
