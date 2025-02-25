package com.wuzhaoyan.service.impl;

import com.wuzhaoyan.mapper.adminMapper;
import com.wuzhaoyan.pojo.adminUser;
import com.wuzhaoyan.service.adminService;
import com.wuzhaoyan.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class adminServiceImpl implements adminService {

    @Autowired
    public adminMapper adminMapper;

    @Override
    public adminUser findByName(String username) {
        return adminMapper.findByName(username);
    }

    @Override
    public void register(String username, String password) {
        //加密
        String md5String= Md5Util.getMD5String(password);
        //添加
        adminMapper.add(username,md5String);
    }
}
