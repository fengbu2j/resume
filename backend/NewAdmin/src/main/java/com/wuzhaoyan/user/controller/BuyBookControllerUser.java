package com.wuzhaoyan.user.controller;

import com.wuzhaoyan.user.pojo.BuybookUser;
import com.wuzhaoyan.user.service.BuyBookServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/user/buybooks")
public class BuyBookControllerUser {
    @Autowired
    private BuyBookServiceUser buyBookServiceUser;

    // 查看消费记录接口
    @GetMapping("/{userId}")
    public List<BuybookUser> getBuyRecordsByUserId(@PathVariable("userId") Integer userId) {
        return buyBookServiceUser.getBuyRecordsByUserId(userId);
    }

    // 查看所有买书记录接口
    @GetMapping
    public List<BuybookUser> getAllBuyRecords() {
        return buyBookServiceUser.getAllBuyRecords();
    }

    // 修改消费记录接口
    @PutMapping("/update")
    public Boolean updateBuyRecord(
                                  @RequestParam("bookId") Integer bookId,
                                  @RequestParam("userId") Integer userId,
                                  @RequestParam("time") java.sql.Date time,
                                  @RequestParam("money") Float money) {
        return buyBookServiceUser.updateBuyRecord(userId,bookId, money, time);
    }
}