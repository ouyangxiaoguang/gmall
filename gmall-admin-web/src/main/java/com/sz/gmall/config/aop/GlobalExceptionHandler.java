package com.sz.gmall.config.aop;
/*
 *
 * 统一处理所有异常，给前端返回500的json
 *
 */

import com.sz.gmall.to.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = ArithmeticException.class)
    public Object handlerException(Exception e) {
        logger.error(String.valueOf(e.getMessage()));
        return new CommonResult().validateFailed("算数异常。。。。");
    }

    @ExceptionHandler(value = NullPointerException.class)
    public Object handlerException2(Exception e) {
        logger.error(String.valueOf(e.getMessage()));
        return new CommonResult().validateFailed("空指针。。。。");
    }

}
