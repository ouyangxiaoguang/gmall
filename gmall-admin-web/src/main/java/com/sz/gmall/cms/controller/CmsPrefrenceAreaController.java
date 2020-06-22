package com.sz.gmall.cms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sz.gmall.cms.entity.PrefrenceArea;
import com.sz.gmall.cms.service.PrefrenceAreaService;
import com.sz.gmall.to.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Api(tags = "CmsPrefrenceAreaController", description = "商品优选管理")
@RequestMapping("/prefrenceArea")
public class CmsPrefrenceAreaController {

    private static final Logger logger = LoggerFactory.getLogger(CmsPrefrenceAreaController.class);

    @Reference
    private PrefrenceAreaService prefrenceAreaService;

    @ApiOperation(value = "查询全部商品优选")
    @GetMapping(value = "/listAll")
    public Object getAllList() {
        List<PrefrenceArea> prefrenceAreaList = prefrenceAreaService.findListByAll();
        return new CommonResult().success(prefrenceAreaList);
    }



}
