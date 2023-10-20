package com.universal.system.common.exception;

import com.universal.system.common.result.AjaxResult;
import com.universal.system.common.result.HttpStatus;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理类
 * @author 姓陈的
 * 2023/6/5 14:51
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public AjaxResult error(Exception e){
        e.printStackTrace();
        return AjaxResult.error();
    }


    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public AjaxResult error(ArithmeticException e){
        e.printStackTrace();
        return AjaxResult.error("特定异常类");
    }

    @ExceptionHandler(UniversalException.class)
    @ResponseBody
    public AjaxResult error(UniversalException e){
        e.printStackTrace();
        return AjaxResult.error(e.getCode(),e.getMsg());
    }


    @ExceptionHandler(ExpiredJwtException.class)
    @ResponseBody
    public AjaxResult error(ExpiredJwtException e){
        e.printStackTrace();
        return AjaxResult.error(HttpStatus.FORBIDDEN,"认证过期");
    }



}
