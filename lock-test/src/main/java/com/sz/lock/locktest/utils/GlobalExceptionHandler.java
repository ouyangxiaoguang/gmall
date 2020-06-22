package com.sz.lock.locktest.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {



    @ExceptionHandler(value = ServiceException.class)
    public Object handlerException(Exception e) {
        log.error(String.valueOf(e.getMessage()));
        return new CommonResult().validateFailed(e.getMessage());
    }
}
