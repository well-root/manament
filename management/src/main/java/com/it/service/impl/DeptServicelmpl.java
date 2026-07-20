package com.it.service.impl;

import com.it.mapper.DeptMapper;
import com.it.pojo.Dept;
import com.it.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServicelmpl implements DeptService {


    @Autowired
    private DeptMapper deptMapper;
    public List<Dept> findAll(){
        return deptMapper.findAll();
    }

    public void deleteById(Integer id){
        deptMapper.deleteById(id);

    }


    public void save(Dept dept){
//        补全所有的基础属性
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        //保存所有加入的部门
        deptMapper.insert(dept);

    }

    public Dept getById(Integer id){
        return deptMapper.getById(id);
    }

    public void update(Dept dept){
        dept.setUpdateTime(LocalDateTime.now());

//        保存部门
        deptMapper.update(dept);
    }
}
