package com.wuzhaoyan.user.controller;

import com.wuzhaoyan.user.pojo.AdUser;
import com.wuzhaoyan.user.service.AdServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/ad")
public class AdControllerUser {
    @Autowired
    private AdServiceUser adService;

    // 请求广告
    @GetMapping("/{id}")
    public Optional<AdUser> getAd(@PathVariable("") Integer userId) {
        return adService.getRandomAd();
    }
}
