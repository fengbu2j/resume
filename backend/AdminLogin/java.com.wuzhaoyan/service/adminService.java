package com.wuzhaoyan.service;

import com.wuzhaoyan.pojo.adminUser;


public interface adminService {

    adminUser findByName(String username);
    void register(String username,String password);
}
