package com.sz.gmall.ums.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sz.gmall.ums.entity.Admin;
import com.sz.gmall.ums.mapper.AdminMapper;
import com.sz.gmall.ums.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author GG
 * @since 2020-06-07
 */
@Component
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(String username, String password) {
        String md5Pwd = DigestUtils.md5DigestAsHex(password.getBytes());
        QueryWrapper<Admin> adminQueryWrapper = new QueryWrapper<Admin>().eq("username", username).eq("password", md5Pwd);
        Admin admin = adminMapper.selectOne(adminQueryWrapper);

        return admin;
    }

    @Override
    public Admin getUserInfo(Admin admin) {
        return adminMapper.selectOne(new QueryWrapper<Admin>().eq("username",admin.getUsername()));
    }
}
