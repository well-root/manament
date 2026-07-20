package com.it.aop;

import com.it.anno.LogOperation;
import com.it.mapper.OperateLogMapper;
import com.it.pojo.OperateLog;
import com.it.utils.CurrentHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 操作日志切面类
 * 使用环绕通知 @Around 记录系统所有增、删、改功能接口的操作日志
 */
@Aspect
@Component
public class OperationLogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    /**
     * 环绕通知：拦截所有标注了 @LogOperation 注解的方法
     */
    @Around("@annotation(log)")
    public Object around(ProceedingJoinPoint joinPoint, LogOperation log) throws Throwable {
        // 记录开始时间
        long startTime = System.currentTimeMillis();

        // 执行原始方法
        Object result = joinPoint.proceed();

        // 记录结束时间
        long endTime = System.currentTimeMillis();
        // 计算耗时
        long costTime = endTime - startTime;

        // 构建操作日志对象
        OperateLog operateLog = new OperateLog();
        operateLog.setOperateEmpId(getCurrentUserId());
        operateLog.setOperateTime(LocalDateTime.now());
        operateLog.setClassName(joinPoint.getTarget().getClass().getName());
        operateLog.setMethodName(joinPoint.getSignature().getName());
        operateLog.setMethodParams(Arrays.toString(joinPoint.getArgs()));
        operateLog.setReturnValue(result != null ? result.toString() : "void");
        operateLog.setCostTime(costTime);

        // 插入日志到数据库
        operateLogMapper.insert(operateLog);

        return result;
    }

    /**
     * 从 ThreadLocal 中获取当前登录用户ID
     */
    private Integer getCurrentUserId() {
        return CurrentHolder.getCurrentId();
    }
}
