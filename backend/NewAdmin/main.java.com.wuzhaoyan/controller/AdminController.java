package com.wuzhaoyan.controller;

import com.wuzhaoyan.pojo.Admin;
import com.wuzhaoyan.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    // 管理员登录接口
    @PostMapping("/login")
    public String adminLogin(@RequestParam("username") String username,
                             @RequestParam("password") String password) {
        Admin admin = adminService.login(username, password);
        if (admin != null) {
            return "登录成功，欢迎管理员：" + admin.getUsername();
        } else {
            return "登录失败，用户名或密码错误";
        }
    }
}