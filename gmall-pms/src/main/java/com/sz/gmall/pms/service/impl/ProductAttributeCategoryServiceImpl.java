package com.sz.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sz.gmall.pms.entity.ProductAttributeCategory;
import com.sz.gmall.pms.mapper.ProductAttributeCategoryMapper;
import com.sz.gmall.pms.service.ProductAttributeCategoryService;
import com.sz.gmall.vo.PageInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 产品属性分类表 服务实现类
 * </p>
 *
 * @author GG
 * @since 2020-06-07
 */
@Component
@Service
public class ProductAttributeCategoryServiceImpl extends ServiceImpl<ProductAttributeCategoryMapper, ProductAttributeCategory> implements ProductAttributeCategoryService {
    @Autowired
    private ProductAttributeCategoryMapper productAttributeCategoryMapper;


    @Override
    public PageInfoVO getProductAttributeByPage(Integer pageNum, Integer pageSize) {

        IPage<ProductAttributeCategory> page = productAttributeCategoryMapper.selectPage(new Page<ProductAttributeCategory>(pageNum,pageSize), new QueryWrapper<ProductAttributeCategory>());
        PageInfoVO pageInfoVO = new PageInfoVO(page.getTotal(),
                page.getPages(),
                pageSize.longValue(),
                page.getRecords(),
                page.getCurrent());
        return pageInfoVO;
    }
}
