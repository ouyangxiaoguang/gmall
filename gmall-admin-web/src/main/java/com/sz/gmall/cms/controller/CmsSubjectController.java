package com.sz.gmall.cms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sz.gmall.cms.entity.Subject;
import com.sz.gmall.cms.service.SubjectService;
import com.sz.gmall.to.CommonResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Api(tags = "CmsSubjectController", description = "商品专题管理")
@RequestMapping("/subject")
public class CmsSubjectController {
    private static final Logger logger = LoggerFactory.getLogger(CmsSubjectController.class);
    @Reference
    private SubjectService subjectService;


    @ApiOperation(value = "查询全部商品专题")
    @GetMapping(value = "/listAll")
    public Object getAllList() {
        List<Subject> subjectList = subjectService.findListByAll();
        return new CommonResult().success(subjectList);
    }


}
