package com.sz.gmall.pms.service;

import com.sz.gmall.pms.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sz.gmall.vo.PageInfoVO;
import com.sz.gmall.vo.product.PmsProductParam;
import com.sz.gmall.vo.product.PmsProductQueryParam;

/**
 * <p>
 * 商品信息 服务类
 * </p>
 *
 * @author GG
 * @since 2020-06-07
 */
public interface ProductService extends IService<Product> {

    PageInfoVO productPageinfo(PmsProductQueryParam productQueryParam);

    void saveProduct(PmsProductParam productParam);
}
