package com.wuzhaoyan.controller;

import com.wuzhaoyan.pojo.BuyVip;
import com.wuzhaoyan.service.BuyVipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/admin/buyvip")
public class BuyVipController {
    @Autowired
    private BuyVipService buyVipService;

    // 查看VIP购买记录
    @GetMapping("/{userId}")
    public List<BuyVip> getBuyVipRecordsByUserId(@PathVariable("userId") Integer userId) {
        return buyVipService.getBuyVipRecordsByUserId(userId);
    }

    // 查看所有VIP购买记录
    @GetMapping
    public List<BuyVip> getAllBuyVipRecords() {
        return buyVipService.getAllBuyVipRecords();
    }

    // 购买VIP接口
    @PostMapping("/buy")
    public boolean buyVip(@RequestParam("userId") Integer userId,
                          @RequestParam("money") Float money,
                          @RequestParam("time") java.sql.Date time) {
        try {
            return buyVipService.buyVip(userId, money, time);
        } catch (Exception e) {
            return false;
        }
    }
}