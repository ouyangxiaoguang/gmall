package com.sz.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sz.gmall.pms.entity.Brand;
import com.sz.gmall.pms.mapper.BrandMapper;
import com.sz.gmall.pms.service.BrandService;
import com.sz.gmall.vo.PageInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author GG
 * @since 2020-06-07
 */
@Component
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public PageInfoVO brandPageInfo(String keyword, Integer pageNum, Integer pageSize) {
        QueryWrapper<Brand> queryWrapper = null;
        if (!StringUtils.isEmpty(keyword)){
            queryWrapper = new QueryWrapper<Brand>().like("name",keyword);
        }

        IPage<Brand> brandIPage = brandMapper.selectPage(new Page<>(pageNum.longValue(),pageSize.longValue()),queryWrapper);

        PageInfoVO page = new PageInfoVO(brandIPage.getTotal(),
               brandIPage.getPages(),
               pageSize.longValue(),
               brandIPage.getRecords(),
               brandIPage.getCurrent());
        return page;
    }
}
