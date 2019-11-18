package com.lzh.cloud.service;

import com.lzh.cloud.model.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//服务降级
//不要忘记添加
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept get(long id) {
                return new Dept().setDeptno(id)
                        .setDname("该ID：" + id + "没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
                        .setDb_source("no this database in MySQL");
            }

            @Override
            public List<Dept> list() {
                List<Dept> list = new ArrayList<>();
                list.add(new Dept().setDeptno(-1L)
                        .setDname("该ID：-1 没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
                        .setDb_source("no this database in MySQL"));
                return list;
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };
    }
}



