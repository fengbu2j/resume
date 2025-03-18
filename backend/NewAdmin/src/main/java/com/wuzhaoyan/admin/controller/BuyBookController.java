package com.wuzhaoyan.admin.controller;

import com.wuzhaoyan.admin.pojo.BuyBook;
import com.wuzhaoyan.admin.service.BuyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/admin/buybooks")
public class BuyBookController {
    @Autowired
    private BuyBookService buyBookService;

    // 查看消费记录接口
    @GetMapping("/{userId}")
    public List<BuyBook> getBuyRecordsByUserId(@PathVariable("userId") Integer userId) {
        return buyBookService.getBuyRecordsByUserId(userId);
    }

    // 查看所有买书记录接口
    @GetMapping
    public List<BuyBook> getAllBuyRecords() {
        return buyBookService.getAllBuyRecords();
    }

    // 修改消费记录接口
    @PutMapping("/update")
    public boolean updateBuyRecord(@RequestParam("userId") Integer userId,
                                   @RequestParam("bookId") Integer bookId,
                                   @RequestParam("money") Float money,
                                   @RequestParam("time") java.sql.Date time) {
        try {
            boolean result = buyBookService.updateBuyRecord(userId, bookId, money, time);
            return result;
        } catch (Exception e) {
            return false;
        }
    }
}
