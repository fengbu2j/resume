package com.wuzhaoyan.service;

import com.wuzhaoyan.pojo.Book;
import com.wuzhaoyan.repository.BookRepository;
import com.wuzhaoyan.repository.BuyBookRepository;
import com.wuzhaoyan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebAnalyseService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BuyBookRepository buyBookRepository;

    // 返回所有用户的数目
    public long getTotalUserCount() {
        return userRepository.count();
    }

    // 返回所有VIP用户的数目
    public long getTotalVipUserCount() {
        return userRepository.countByPermission(1);
    }

    // 返回所有书籍的数目
    public long getTotalBookCount() {
        return bookRepository.count();
    }

    // 根据category返回它们的number总和
    public List<Object[]> getSumNumberByCategory() {
        return bookRepository.getSumNumberByCategory();
    }

    // 根据类别统计消费金额
    public List<Object[]> getTotalSpendingByCategory() {
        return buyBookRepository.getTotalSpendingByCategory();
    }

}