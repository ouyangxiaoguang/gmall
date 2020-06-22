package com.sz.lock.locktest.controller;

import com.sz.lock.locktest.annotation.ApiIdempotent;
import com.sz.lock.locktest.service.TokenService;
import com.sz.lock.locktest.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class TestController {

    @Autowired
    private TokenService tokenService;

    @ApiIdempotent
    @PostMapping("testIdempotence")
    public Object testIdempotence() {
        tokenService.testIdempotence();
        return  new CommonResult().success(null);
    }
    @GetMapping("test")
    public Object test() {
        System.out.println("aaaaa");
        return  new CommonResult().success(null);
    }
}
