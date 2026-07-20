package com.it.service;

import com.it.mapper.DeptMapper;
import com.it.pojo.Dept;

import java.util.List;

public interface DeptService {

//    查询所以的部门
    public List<Dept> findAll();

    void deleteById(Integer id);

    void save(Dept dept);

    Dept getById(Integer id);

    void update(Dept dept);

}

