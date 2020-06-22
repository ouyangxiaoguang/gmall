package com.sz.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sz.gmall.constant.SysCacheConstant;
import com.sz.gmall.pms.entity.ProductCategory;
import com.sz.gmall.pms.mapper.ProductCategoryMapper;
import com.sz.gmall.pms.service.ProductCategoryService;
import com.sz.gmall.vo.product.PmsProductCategoryWithChildrenItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 产品分类 服务实现类
 * </p>
 *
 * @author GG
 * @since 2020-06-07
 */
@Component
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {

    private static final Logger logger = LoggerFactory.getLogger(ProductCategoryServiceImpl.class);
    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<PmsProductCategoryWithChildrenItem> listCatelogWithChilder(Integer i) {
        List<PmsProductCategoryWithChildrenItem> items = null;
        if (!redisTemplate.hasKey(SysCacheConstant.CATEGORY_MENU_CACHE_KEY)){
            logger.info("CATEGORY_MENU_CACHE_KEY->失效，命中数据库查询");
            items = productCategoryMapper.listCatelogWithChilder(i);
            redisTemplate.opsForValue().set(SysCacheConstant.CATEGORY_MENU_CACHE_KEY,items);
        }
        items = (List<PmsProductCategoryWithChildrenItem>) redisTemplate.opsForValue().get(SysCacheConstant.CATEGORY_MENU_CACHE_KEY);
        return items;
    }
}
