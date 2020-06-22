package com.sz.gmall.pms.service;

import com.sz.gmall.pms.entity.ProductAttribute;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sz.gmall.vo.PageInfoVO;

/**
 * <p>
 * 商品属性参数表 服务类
 * </p>
 *
 * @author GG
 * @since 2020-06-07
 */
public interface ProductAttributeService extends IService<ProductAttribute> {

    PageInfoVO getProductAttributeCidAndTypePages(Long cid, Integer type, Integer pageNum, Integer pageSize);
}
