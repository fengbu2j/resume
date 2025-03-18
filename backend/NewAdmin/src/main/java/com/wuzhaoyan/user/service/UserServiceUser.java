package com.wuzhaoyan.user.service;

import com.wuzhaoyan.user.pojo.UserUser;
import com.wuzhaoyan.user.repository.UserRepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceUser {

    @Autowired
    public UserRepositoryUser userRepositoryUser;

    public UserUser findByUsername(String username) {
        return userRepositoryUser.findByUsername(username);
    }

    public void register(String username, String password,Integer permission) {
        //添加
        UserUser newuser = new UserUser();
        newuser.setPermission(0);
        newuser.setUsername(username);
        newuser.setPassword(password);
        userRepositoryUser.save(newuser);
    }

    // 用户登录
    public UserUser login(String username, String password) {
        UserUser userUser = userRepositoryUser.findByUsername(username);
        if (userUser != null && userUser.getPassword().equals(password)) {
            return userUser; // 登录成功，返回用户对象
        }
        return new UserUser(); // 登录失败，返回空白的User
    }

}
