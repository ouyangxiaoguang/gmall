package com.sz.lock.locktest.controller;

import com.sz.lock.locktest.service.TokenService;
import com.sz.lock.locktest.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerResponse;

@CrossOrigin
@RestController
@RequestMapping("/token")
public class TokenController {
    @Autowired
    private TokenService tokenService;

    @GetMapping
    public CommonResult token() {
        return new CommonResult().success(tokenService.createToken());
    }
}
