package com.lzh.cloud.service;

import com.lzh.cloud.model.Dept;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author lzh
 * create 2019-11-05-10:24
 */

public interface DeptService {

    boolean add(Dept dept);

    Dept get(Long id);

    List<Dept> list();

    Object discovery();
}
