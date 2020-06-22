package com.sz.gamll.cms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sz.gamll.cms.mapper.PrefrenceAreaMapper;
import com.sz.gmall.cms.entity.PrefrenceArea;

import com.sz.gmall.cms.service.PrefrenceAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 优选专区 服务实现类
 * </p>
 *
 * @author GG
 * @since 2020-06-11
 */
@Component
@Service
public class PrefrenceAreaServiceImpl extends ServiceImpl<PrefrenceAreaMapper, PrefrenceArea> implements PrefrenceAreaService {

    @Autowired
    private PrefrenceAreaMapper prefrenceAreaMapper;


    @Override
    public List<PrefrenceArea> findListByAll() {
        return prefrenceAreaMapper.selectList(new QueryWrapper<PrefrenceArea>());
    }
}
