package com.sz.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sz.gmall.pms.entity.ProductAttribute;
import com.sz.gmall.pms.mapper.ProductAttributeMapper;
import com.sz.gmall.pms.service.ProductAttributeService;
import com.sz.gmall.vo.PageInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 商品属性参数表 服务实现类
 * </p>
 *
 * @author GG
 * @since 2020-06-07
 */
@Component
@Service
public class ProductAttributeServiceImpl extends ServiceImpl<ProductAttributeMapper, ProductAttribute> implements ProductAttributeService {

    @Autowired
    private ProductAttributeMapper productAttributeMapper;

    @Override
    public PageInfoVO getProductAttributeCidAndTypePages(Long cid, Integer type, Integer pageNum, Integer pageSize) {
        QueryWrapper<ProductAttribute> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_attribute_category_id", cid)
                .eq("type", type);
        IPage<ProductAttribute> page = productAttributeMapper.selectPage(new Page<ProductAttribute>(pageNum, pageSize), queryWrapper);
        return PageInfoVO.getPage(page,pageSize.longValue());
    }
}
