package com.it.service;

import com.it.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {

//    统计各个职位？
    JobOption getEmpJobData();
    /**
     * 统计员工性别信息
     */
    List<Map<String, Object>> getEmpGenderData();

}
