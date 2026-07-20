package com.it.service;

import com.it.pojo.Emp;
import com.it.pojo.EmpQueryParam;
import com.it.pojo.LoginInfo;
import com.it.pojo.PageResult;

import java.util.List;

public interface EmpService {

    // 分页查询
    PageResult<Emp> page(EmpQueryParam empQueryParam);

//    新加员工/

    void save(Emp emp);

    /**
     * 批量删除员工
     */
    void deleteByIds(List<Integer> ids);

    Emp getInfo(Integer id);


//      更新员工信息
    void update(Emp emp);

    LoginInfo login(Emp emp);

}
