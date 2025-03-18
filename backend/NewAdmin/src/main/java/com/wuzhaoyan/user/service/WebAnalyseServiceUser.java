package com.wuzhaoyan.user.service;

import com.wuzhaoyan.user.repository.BookRepositoryUser;
import com.wuzhaoyan.user.repository.BuyBookRepositoryUser;
import com.wuzhaoyan.user.repository.UserRepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebAnalyseServiceUser {
    @Autowired
    private UserRepositoryUser userRepositoryUser;

    @Autowired
    private BookRepositoryUser bookRepositoryUser;

    @Autowired
    private BuyBookRepositoryUser buyBookRepositoryUser;

    // 返回所有用户的数目
    public long getTotalUserCount() {
        return userRepositoryUser.count();
    }

    // 返回所有VIP用户的数目
    public long getTotalVipUserCount() {
        return userRepositoryUser.countByPermission(1);
    }

    // 返回所有书籍的数目
    public long getTotalBookCount() {
        return bookRepositoryUser.count();
    }

    // 根据category返回它们的number总和
    public List<Object[]> getSumNumberByCategory() {
        return bookRepositoryUser.getSumNumberByCategory();
    }

    // 根据类别统计消费金额
    public List<Object[]> getTotalSpendingByCategory() {
        return buyBookRepositoryUser.getTotalSpendingByCategory();
    }

}