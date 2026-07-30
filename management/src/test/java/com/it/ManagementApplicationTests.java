package com.it;

import com.it.mapper.EmpMapper;
import com.it.pojo.Emp;
import com.it.pojo.EmpQueryParam;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ManagementApplicationTests {

    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testlist(){
        List<Emp> empList = empMapper.list(new EmpQueryParam());
        empList.forEach(System.out::println);
    }
}
