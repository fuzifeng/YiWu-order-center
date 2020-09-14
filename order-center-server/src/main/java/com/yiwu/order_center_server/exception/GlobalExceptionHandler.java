package com.yiwu.order_center_server.exception;

import com.yiwu.order_center_client.common.Resp;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: fuzf
 * @Date: 2020/9/14 14:10
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Resp customException(Exception e) {
        return Resp.error(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public Resp businessException(BusinessException e) {
        return Resp.error(e.getCode(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public Resp runException(RuntimeException e) {
        return Resp.error(e.getMessage());
    }
}
