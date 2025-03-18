package com.wuzhaoyan.user.controller;

import com.wuzhaoyan.user.service.WebAnalyseServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/user/analyse")
public class WebAnalyseControllerUser {
    @Autowired
    private WebAnalyseServiceUser webAnalyseServiceUser;

    // 返回所有用户的数目
    @GetMapping("/users")
    public long getTotalUserCount() {
        return webAnalyseServiceUser.getTotalUserCount();
    }

    // 返回所有VIP用户的数目
    @GetMapping("/vips")
    public long getTotalVipUserCount() {
        return webAnalyseServiceUser.getTotalVipUserCount();
    }

    // 返回所有书籍的数目
    @GetMapping("/books")
    public long getTotalBookCount() {
        return webAnalyseServiceUser.getTotalBookCount();
    }

    // 根据category返回它们的number总和
    @GetMapping("/sumNumByCate")
    public List<Object[]> getSumNumberByCategory() {
        return webAnalyseServiceUser.getSumNumberByCategory();
    }

    // 根据类别统计消费金额
    @GetMapping("/totalMoneyByCate")
    public List<Object[]> getTotalSpendingByCategory() {
        return webAnalyseServiceUser.getTotalSpendingByCategory();
    }

}