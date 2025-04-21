package com.wuzhaoyan.admin.service;

import com.wuzhaoyan.admin.pojo.Admin;
import com.wuzhaoyan.admin.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;

    // 管理员登录
    public Admin login(String username, String password) {
        // 直接通过数据库查询用户名和密码
        Admin admin = adminMapper.findByUsername(username);
        if (admin != null && admin.getPassword().equals(password)) {
            return admin; // 登录成功
        }
        return null; // 登录失败
    }

    // 添加管理员
    public void addAdmin(Admin admin) {
        adminMapper.insert(admin);
    }
}