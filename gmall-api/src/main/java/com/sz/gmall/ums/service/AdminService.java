package com.sz.gmall.ums.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sz.gmall.ums.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author GG
 * @since 2020-06-07
 */
public interface AdminService extends IService<Admin> {

    Admin login(String username, String password);

    Admin getUserInfo(Admin admin);
}
