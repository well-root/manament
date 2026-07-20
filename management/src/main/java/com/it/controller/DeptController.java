package com.it.controller;

import com.it.anno.LogOperation;
import com.it.pojo.Dept;
import com.it.pojo.Result;
import com.it.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//自动将返回值变为json格式

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 查询部门列表
     */
    @GetMapping
    public Result list(){
        List<Dept> deptList = deptService.findAll();
        log.info("查询部门列表");
        return Result.success(deptList);
    }

//    删除操作
    @LogOperation
    @DeleteMapping
    public Result delete(Integer id){
//        System.out.println("根据id来删除部门="+id);
        log.info("根据id删除部门, id: {}" , id);
        deptService.deleteById(id);
        return Result.success();
    }

    @LogOperation
    @PostMapping
    public Result save(@RequestBody Dept dept) {
//
        log.info("新增部门, dept: {}" , dept);
        deptService.save(dept);
        return Result.success();

    }
//        根据id来查询对应的数据
        @GetMapping("/{id}")
        public Result getById(@PathVariable Integer id){
//            System.out.println("根据id来查询信息,id"+id);
            log.info("根据ID查询, id: {}" , id);
            Dept dept=deptService.getById(id);
            return  Result.success(dept);
        }

//        修改部门
        @LogOperation
    @PutMapping
    public Result update(@RequestBody Dept dept){
//            System.out.println("修改部门,dept="+dept);
            log.info("修改部门, dept: {}" , dept);
            deptService.update(dept);
            return Result.success();
        }
    }


