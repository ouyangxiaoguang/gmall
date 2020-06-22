package com.sz.gmall.ums.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sz.gmall.to.CommonResult;


import com.sz.gmall.ums.entity.MemberLevel;
import com.sz.gmall.ums.service.MemberLevelService;
import groovy.util.logging.Slf4j;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 后台用户管理
 */
@CrossOrigin
@RestController
@Api(tags = "UmsMemberLevelController", description = "后台用户管理")
@RequestMapping("/memberLevel")
@Slf4j
public class UmsMemberLevelController {
    private static final Logger logger = LoggerFactory.getLogger(UmsMemberLevelController.class);
    @Reference
    private MemberLevelService memberLevelService;


    @ApiOperation(value = "查询所有会员等级")
    @GetMapping(value = "/list")
    public Object getAllByDefaultStatus(@RequestParam(name = "defaultStatus", required = false) Integer defaultStatus) {
        List<MemberLevel> memberLevels = memberLevelService.findListByDefaultStatus(defaultStatus);
        return new CommonResult().success(memberLevels);
    }


}
