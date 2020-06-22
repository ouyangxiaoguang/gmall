package com.sz.lock.locktest.utils;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class ServiceException extends RuntimeException {

    public ServiceException(String message) {
        super(message);
    }
}
