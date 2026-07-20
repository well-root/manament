package com.it.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class EmpQueryParam {
    private Integer page=1;
    private Integer pageSize=10;
    private String name;
    private Integer gender;
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private LocalDateTime begin;
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private LocalDateTime end;



}
