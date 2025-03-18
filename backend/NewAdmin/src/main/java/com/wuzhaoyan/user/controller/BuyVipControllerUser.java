package com.wuzhaoyan.user.controller;

import com.wuzhaoyan.user.pojo.BuyVipUser;
import com.wuzhaoyan.user.service.BuyVipServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/user/buyvip")
public class BuyVipControllerUser {
    @Autowired
    private BuyVipServiceUser buyVipServiceUser;

    // 查看VIP购买记录
    @GetMapping("/{userId}")
    public List<BuyVipUser> getBuyVipRecordsByUserId(@PathVariable("userId") Integer userId) {
        return buyVipServiceUser.getBuyVipRecordsByUserId(userId);
    }

//    // 查看所有VIP购买记录
//    @GetMapping
//    public List<BuyVip> getAllBuyVipRecords() {
//        return buyVipService.getAllBuyVipRecords();
//    }

    // 购买VIP接口
    @PostMapping("/buy")
    public Boolean buyVip(@RequestParam("userId") Integer userId,
                          @RequestParam("money") Float money,
                          @RequestParam("time") java.sql.Date time) {
        return buyVipServiceUser.buyVip(userId, money, time);

    }
}