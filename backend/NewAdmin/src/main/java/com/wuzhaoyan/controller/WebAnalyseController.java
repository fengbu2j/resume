package com.wuzhaoyan.controller;

import com.wuzhaoyan.pojo.Book;
import com.wuzhaoyan.service.WebAnalyseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/analyse")
public class WebAnalyseController {
    @Autowired
    private WebAnalyseService webAnalyseService;

    // 返回所有用户的数目
    @GetMapping("/users")
    public long getTotalUserCount() {
        return webAnalyseService.getTotalUserCount();
    }

    // 返回所有VIP用户的数目
    @GetMapping("/vips")
    public long getTotalVipUserCount() {
        return webAnalyseService.getTotalVipUserCount();
    }

    // 返回所有书籍的数目
    @GetMapping("/books")
    public long getTotalBookCount() {
        return webAnalyseService.getTotalBookCount();
    }

    // 根据category返回它们的number总和
    @GetMapping("/sumNumByCate")
    public List<Object[]> getSumNumberByCategory() {
        return webAnalyseService.getSumNumberByCategory();
    }

    // 根据类别统计消费金额
    @GetMapping("/totalMoneyByCate")
    public List<Object[]> getTotalSpendingByCategory() {
        return webAnalyseService.getTotalSpendingByCategory();
    }

}