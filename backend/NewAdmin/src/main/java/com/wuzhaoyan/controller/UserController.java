package com.wuzhaoyan.controller;

import com.wuzhaoyan.pojo.User;
import com.wuzhaoyan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/admin/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User user) {
        user.setId(id);
        return userService.saveUser(user);
    }
//改
    @DeleteMapping("/{id}")
    public Boolean deleteUser(@PathVariable Integer id) {
        try {
            userService.deleteUser(id);
         return true; // 如果没有异常发生，表示删除成功，返回 true
        } catch (Exception e) {
            e.printStackTrace(); // 打印异常信息（建议使用日志框架记录异常）
            return false; // 如果发生异常，表示删除失败，返回 false
        }
}
}