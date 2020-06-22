package com.sz.gmall.pms.service;

import com.sz.gmall.pms.entity.ProductAttributeCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sz.gmall.vo.PageInfoVO;

/**
 * <p>
 * 产品属性分类表 服务类
 * </p>
 *
 * @author GG
 * @since 2020-06-07
 */
public interface ProductAttributeCategoryService extends IService<ProductAttributeCategory> {

    PageInfoVO getProductAttributeByPage(Integer pageNum, Integer pageSize);
}
