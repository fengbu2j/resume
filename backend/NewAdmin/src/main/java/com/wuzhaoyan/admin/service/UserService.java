package com.wuzhaoyan.admin.service;

import com.wuzhaoyan.admin.pojo.User;
import com.wuzhaoyan.admin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUsers() {
        return userMapper.findAll();
    }

    public User getUserById(Integer id) {
        return userMapper.findById(id);
    }

    public User saveUser(User user) {
        userMapper.insert(user);
        return user;
    }

    public void deleteUser(Integer id) {
        userMapper.deleteById(id);
    }
}