package com.zhengdf.manager.admin.exception;

import com.zhengdf.manager.admin.constant.CommonEnums;
import com.zhengdf.manager.admin.domain.response.ResponseInfo;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * @author Zheng Jie
 * @date 2018-11-23
 * 统一异常处理
 */
@Slf4j
@ControllerAdvice
public class BadRequestException{

    @ExceptionHandler(value = AuthorizationException.class)
    @ResponseBody
    //设置响应状态码为：200，结合前端约定的规范处理。也可不设置状态码，前端ajax调用使用error函数进行控制处理
    @ResponseStatus(value=HttpStatus.OK)
    public ResponseInfo defaultErrorHandler(HttpServletRequest req, HttpServletResponse resp, Exception e) throws Exception{
        log.info("异常处理");
        return ResponseInfo.getInstance(CommonEnums.ERROR_AUTHORIZATION);
    }
}
