package com.wuzhaoyan.controller;


import com.wuzhaoyan.pojo.adminUser;
import com.wuzhaoyan.pojo.Result;
import com.wuzhaoyan.service.adminService;
import com.wuzhaoyan.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin")
public class adminController {

    @Autowired
    private adminService adminService;

    @PostMapping("/register")
    public Result register(String username,String password)
    {

        adminUser u= adminService.findByName(username);
        if(u==null)
        {
            adminService.register(username,password);
            return Result.success();
        }else{
            return Result.error("用户名已存在");
        }

    }

    @PostMapping("/login")
    public Result<String> login(String username,String password){
        adminUser admin=adminService.findByName(username);
        if(admin==null)
        {
            return Result.error("用户不存在");
        }

        if(Md5Util.getMD5String(password).equals(admin.getPassword()))
        {
            return Result.success("jwt");
        }

        return Result.error("密码错误");
    }
}
