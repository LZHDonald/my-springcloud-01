package com.lzh.cloud.dao;

import com.lzh.cloud.model.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lzh
 * create 2019-05-18-16:39
 */

@Mapper
public interface DeptDao {

    @Insert("INSERT INTO dept(dname,db_source) VALUES(#{dname},DATABASE())")
    boolean addDept(Dept dept);

    @Select("select deptno,dname,db_source from dept where deptno=#{id}")
    Dept findById(Long id);

    @Select("select deptno,dname,db_source from dept")
    List<Dept> findAll();
}
