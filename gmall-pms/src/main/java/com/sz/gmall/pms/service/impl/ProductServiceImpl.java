package com.sz.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sz.gmall.pms.entity.*;
import com.sz.gmall.pms.mapper.*;
import com.sz.gmall.pms.service.ProductService;
import com.sz.gmall.vo.PageInfoVO;
import com.sz.gmall.vo.product.PmsProductParam;
import com.sz.gmall.vo.product.PmsProductQueryParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 商品信息 服务实现类
 * </p>
 *
 * @author GG
 * @since 2020-06-07
 */
@Component
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductAttributeValueMapper productAttributeValueMapper;
    @Autowired
    ProductFullReductionMapper productFullReductionMapper;
    @Autowired
    ProductLadderMapper productLadderMapper;
    @Autowired
    SkuStockMapper skuStockMapper;


    private ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    @Override
    public PageInfoVO productPageinfo(PmsProductQueryParam param) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (param.getBrandId() != null) {
            queryWrapper.eq("brand_id", param.getBrandId());
        }
        if (!StringUtils.isEmpty(param.getKeyword())) {
            queryWrapper.like("name", param.getKeyword());
        }
        if (param.getProductCategoryId() != null) {
            queryWrapper.eq("product_category_id", param.getProductCategoryId());
        }
        if (!StringUtils.isEmpty(param.getProductSn())) {
            queryWrapper.like("product_sn", param.getProductSn());
        }
        if (param.getPublishStatus() != null) {
            queryWrapper.eq("publish_status", param.getPublishStatus());
        }
        if (param.getVerifyStatus() != null) {
            queryWrapper.eq("verify_status", param.getVerifyStatus());
        }


        IPage<Product> page = productMapper.selectPage(new Page<Product>(param.getPageNum(), param.getPageSize()), queryWrapper);

        PageInfoVO pageInfoVO = new PageInfoVO(page.getTotal(), page.getPages(), param.getPageSize(), page.getRecords(), page.getCurrent());
        return pageInfoVO;
    }


    @Transactional
    @Override
    public void saveProduct(PmsProductParam productParam) {

        ProductServiceImpl productService = (ProductServiceImpl) AopContext.currentProxy();

        //pms_product商品基础信息
        productService.saveBaseInfo(productParam);
        //pms_sku_stock 库存表
        productService.saveSkuStock(productParam);
        //pms_product_attribute_value商品对应所有属性的值
        productService.saveProductAttributeValue(productParam);
        //pms_product_full_reduction保存商品的满减信息
        productService.saveProductFullReduction(productParam);
        //pms_product_ladder满减表
        productService.saveProductLadder(productParam);


    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveSkuStock(PmsProductParam productParam) {
        List<SkuStock> skuStockList = productParam.getSkuStockList();
        for (int i = 0; i < skuStockList.size(); i++) {
            SkuStock skuStock = skuStockList.get(i);
            skuStock.setProductId(threadLocal.get());
            if (StringUtils.isEmpty(skuStock.getSkuCode())) {
                //skuCode必须有
                //生成规则，商品id_sku自增id
                skuStock.setSkuCode(threadLocal.get() + "_" + i);
            }

            skuStockMapper.insert(skuStock);
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveProductLadder(PmsProductParam productParam) {
        List<ProductLadder> productLadderList = productParam.getProductLadderList();
        productLadderList.forEach((productLadder) -> {
            productLadder.setProductId(threadLocal.get());
            productLadderMapper.insert(productLadder);
        });
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveProductFullReduction(PmsProductParam productParam) {
        List<ProductFullReduction> productFullReductionList = productParam.getProductFullReductionList();
        productFullReductionList.forEach((productFullReduction) -> {
            productFullReduction.setProductId(threadLocal.get());
            productFullReductionMapper.insert(productFullReduction);
        });
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveProductAttributeValue(PmsProductParam productParam) {
        List<ProductAttributeValue> productAttributeValueList =
                productParam.getProductAttributeValueList();
        productAttributeValueList.forEach((item) -> {
            item.setProductId(threadLocal.get());
            productAttributeValueMapper.insert(item);
        });
        int i = 10/0;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveBaseInfo(PmsProductParam productParam) {

        Product product = new Product();
        BeanUtils.copyProperties(productParam, product);
        productMapper.insert(product);
        logger.info("保存商品基础信息，商品id：" + product.getId());
        threadLocal.set(product.getId());
    }
}
