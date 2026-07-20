package com.it.controller;

import com.it.pojo.Emp;
import com.it.pojo.EmpQueryParam;
import com.it.pojo.PageResult;
import com.it.pojo.Result;
import com.it.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RequestMapping("/emps")
@RestController
//员工管理controller

public class EmpController {
    @Autowired
    private EmpService empService;

//    @GetMapping
//    public Result page(@RequestParam(defaultValue = "1") Integer page,
//                       @RequestParam(defaultValue = "10") Integer pageSize,
//                       String name, Integer gender,
//                       @DateTimeFormat(pattern = "yyy-MM-dd") LocalDateTime begin,
//                       @DateTimeFormat(pattern = "yyy-MM-dd") LocalDateTime end)
//            {
//        log.info("分页查询:{},{},{},{},{},{}" , page, pageSize,name,gender,begin,end);
//        PageResult pageResult=empService.page(page, pageSize,name,gender,begin,end);
//        return Result.success(pageResult);
//
//    }

    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        log.info("查询请求参数： {}", empQueryParam);
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }

    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("新增员工:{}",emp);
        empService.save(emp);
        return Result.success();

    }


    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("批量删除员工: ids={} ", ids);
        empService.deleteByIds(ids);
        return Result.success();
    }

    /**
     * 查询回显
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据id查询员工的详细信息");
        Emp emp  = empService.getInfo(id);
        return Result.success(emp);


    }

    /**
     * 更新员工信息
     */
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("修改员工信息, {}", emp);
        empService.update(emp);
        return Result.success();
    }

}



