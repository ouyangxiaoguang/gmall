package com.sz.gmall.ums.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sz.gmall.ums.entity.MemberLevel;
import com.sz.gmall.ums.mapper.MemberLevelMapper;
import com.sz.gmall.ums.service.MemberLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 会员等级表 服务实现类
 * </p>
 *
 * @author GG
 * @since 2020-06-07
 */
@Component
@Service
public class MemberLevelServiceImpl extends ServiceImpl<MemberLevelMapper, MemberLevel> implements MemberLevelService {

    @Autowired
    private MemberLevelMapper memberLevelMapper;


    @Override
    public List<MemberLevel> findListByDefaultStatus(Integer defaultStatus) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("default_status",defaultStatus);
        return memberLevelMapper.selectList(queryWrapper);
    }
}
