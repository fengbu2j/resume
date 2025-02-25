package com.wuzhaoyan.service;

import com.wuzhaoyan.pojo.Admin;
import com.wuzhaoyan.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    // 管理员登录
    public Admin login(String username, String password) {
        Admin admin = adminRepository.findByUsername(username);
        if (admin != null && admin.getPassword().equals(password)) {
            return admin; // 登录成功，返回管理员对象
        }
        return null; // 登录失败，返回null
    }
}