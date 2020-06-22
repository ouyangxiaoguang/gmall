package com.sz.gmall.ums.service;

import com.sz.gmall.ums.entity.MemberLevel;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 会员等级表 服务类
 * </p>
 *
 * @author GG
 * @since 2020-06-07
 */
public interface MemberLevelService extends IService<MemberLevel> {

    List<MemberLevel> findListByDefaultStatus(Integer defaultStatus);
}
