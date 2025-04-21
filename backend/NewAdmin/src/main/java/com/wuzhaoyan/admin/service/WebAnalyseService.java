package com.wuzhaoyan.admin.service;

import com.wuzhaoyan.admin.mapper.BookMapper;
import com.wuzhaoyan.admin.mapper.BuyBookMapper;
import com.wuzhaoyan.admin.mapper.UserMapper;
import com.wuzhaoyan.admin.pojo.CategorySpending;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebAnalyseService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BuyBookMapper buyBookMapper;

    public long getTotalUserCount() {
        return userMapper.count();
    }

    public long getTotalVipUserCount() {
        return userMapper.countByPermission(1);
    }

    public long getTotalBookCount() {
        return bookMapper.count();
    }

    public List<Object[]> getSumNumberByCategory() {
        return bookMapper.getSumNumberByCategory();
    }

    public List<CategorySpending> getTotalSpendingByCategory() {
        return buyBookMapper.getTotalSpendingByCategory();
    }
}