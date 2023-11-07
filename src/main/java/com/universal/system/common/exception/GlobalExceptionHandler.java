package com.universal.system.common.exception;

import com.sun.mail.smtp.SMTPSendFailedException;
import com.universal.system.common.result.AjaxResult;
import com.universal.system.common.result.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理类
 * @author 姓陈的
 * 2023/6/5 14:51
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

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


    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    public AjaxResult handleAccessDeniedException(AccessDeniedException e, HttpServletRequest request){
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',权限校验失败'{}'", requestURI, e.getMessage());
        return AjaxResult.error(HttpStatus.FORBIDDEN, "无权限");
    }

    @ExceptionHandler(SMTPSendFailedException.class)
    @ResponseBody
    public AjaxResult handleSMTPSendFailedException(SMTPSendFailedException e, HttpServletRequest request){
        log.error("邮件发送失败{}，邮箱地址不正确",e.getMessage());
        return AjaxResult.error(HttpStatus.FORBIDDEN, "邮件发送失败，邮箱地址不正确");
    }


}
