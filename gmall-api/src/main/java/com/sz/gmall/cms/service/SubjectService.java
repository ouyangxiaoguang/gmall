package com.sz.gmall.cms.service;

import com.sz.gmall.cms.entity.Subject;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 专题表 服务类
 * </p>
 *
 * @author GG
 * @since 2020-06-07
 */
public interface SubjectService extends IService<Subject> {

    List<Subject> findListByAll();
}
