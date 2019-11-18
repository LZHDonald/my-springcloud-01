package com.lzh.cloud.service;


import com.lzh.cloud.model.Dept;

import java.util.List;

public interface DeptService {
    boolean add(Dept dept);

    Dept get(Long id);

    List<Dept> list();
}

