package com.it;

import com.it.mapper.EmpMapper;
import com.it.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ManagementApplicationTests {
//
//    @Test
//    void contextLoads() {
//    }


    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testlist(){
        List<Emp> empList = empMapper.list();
        empList.forEach(System.out::println);

    }
}
