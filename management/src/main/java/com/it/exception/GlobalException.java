package com.it.exception;


import com.it.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.Message;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@Slf4j
//@RestControllerAdvice
public class GlobalException {
//    @ExceptionHandler
//    public Result handleException(Exception e){
//        log.error("异常信息：{}",e.getMessage());
//        return Result.error("服务器异常");
//    }
//
//    @ExceptionHandler
//    public Result handleDuplicateKeyException(DuplicateKeyException e){
//        log.error("异常信息",e);
//        String massage = e.getMessage();
//        int i = Message.indexOf("Duplicate entry");
//        String errMsg=Message.substring(i);
//        String[] arr=errMsg.split(" ");
//        return Result.error(arr[2]+"已存在");
//
//
//    }
@RestControllerAdvice
public class GlobalExceptionHandler {

    //处理异常
    @ExceptionHandler
    public Result ex(Exception e){//方法形参中指定能够处理的异常类型
        e.printStackTrace();//打印堆栈中的异常信息
        //捕获到异常之后，响应一个标准的Result
        return Result.error("对不起,操作失败,请联系管理员");
    }

}


}
