package com.sz.gamll.cms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sz.gamll.cms.mapper.SubjectMapper;
import com.sz.gmall.cms.entity.Subject;
import com.sz.gmall.cms.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 专题表 服务实现类
 * </p>
 *
 * @author GG
 * @since 2020-06-11
 */
@Component
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public List<Subject> findListByAll() {
        return subjectMapper.selectList(new QueryWrapper<Subject>());
    }
}
