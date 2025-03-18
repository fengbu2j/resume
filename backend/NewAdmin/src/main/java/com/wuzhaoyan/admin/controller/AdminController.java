package com.wuzhaoyan.admin.controller;

import com.wuzhaoyan.admin.pojo.Admin;
import com.wuzhaoyan.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    // 管理员登录接口
    @GetMapping("/login")
    public Boolean adminLogin(@RequestParam("username") String username,
                              @RequestParam("password") String password) {
        Admin admin = adminService.login(username, password);
        if (admin != null) {
            return true;
        } else {
            return false;
        }
    }
}