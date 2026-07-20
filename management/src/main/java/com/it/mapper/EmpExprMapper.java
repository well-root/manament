package com.it.mapper;

import com.it.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// 工作经历
@Mapper
public interface EmpExprMapper {

//    List<EmpExpr> list(EmpQueryParam empQueryParam);
    public void insertBatch(List<EmpExpr> exprList);

    /**
     * 根据员工的ID批量删除工作经历信息
     */
    void deleteByEmpIds(List<Integer> empIds);

}
