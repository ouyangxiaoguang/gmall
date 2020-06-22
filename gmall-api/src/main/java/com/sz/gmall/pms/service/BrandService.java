package com.sz.gmall.pms.service;

import com.sz.gmall.pms.entity.Brand;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sz.gmall.vo.PageInfoVO;

/**
 * <p>
 * 品牌表 服务类
 * </p>
 *
 * @author GG
 * @since 2020-06-07
 */
public interface BrandService extends IService<Brand> {

    PageInfoVO brandPageInfo(String keyword, Integer pageNum, Integer pageSize);
}
