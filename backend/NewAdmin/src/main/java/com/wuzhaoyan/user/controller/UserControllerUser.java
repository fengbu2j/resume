package com.wuzhaoyan.user.controller;

import com.wuzhaoyan.user.pojo.UserUser;
import com.wuzhaoyan.user.service.UserServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@CrossOrigin
@RestController
@RequestMapping("/user/users")
public class UserControllerUser {
    @Autowired
    private UserServiceUser userServiceUser;

    @PostMapping("/register")
    public Boolean register(String username,String password,Integer permission)
    {

        UserUser u= userServiceUser.findByUsername(username);
        if(u==null)
        {
            UserUser u1 = new UserUser();
            u1.setPermission(0);
            userServiceUser.register(username,password,permission);
            return Boolean.TRUE;
        }else{
            return Boolean.FALSE;
        }

    }

    @PostMapping("/login")
    public UserUser login(@RequestParam("username") String username,
                          @RequestParam("password") String password) {
        UserUser userUser = userServiceUser.login(username, password);
        Map<String, Object> response = new HashMap<>();
        if (userUser != null) {
            return userUser;
        } else {
            userUser.setId(-1);
            return userUser;
        }
    }

}
