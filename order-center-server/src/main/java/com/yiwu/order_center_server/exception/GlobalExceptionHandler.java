package com.yiwu.order_center_server.exception;

import com.yiwu.order_center_client.common.Resp;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

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

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public Resp handle(MethodArgumentNotValidException e) {
        String msg = e.getBindingResult().getFieldError().getDefaultMessage();
        if (StringUtils.isEmpty(msg)) {
            msg = "请求参数校验失败";
        }
        return Resp.error(msg);
    }

    @ExceptionHandler({SQLException.class})
    @ResponseBody
    public Resp handle(SQLException e) {
//        ULogger.error("SQL异常", new Object[]{e});

        return Resp.error("DB异常:" + e.getMessage());
    }
}
