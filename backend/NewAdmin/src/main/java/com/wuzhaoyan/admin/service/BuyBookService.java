package com.wuzhaoyan.admin.service;

import com.wuzhaoyan.admin.pojo.BuyBook;
import com.wuzhaoyan.admin.mapper.BuyBookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyBookService {
    @Autowired
    private BuyBookMapper buyBookMapper;

    public List<BuyBook> getBuyRecordsByUserId(Integer userId) {
        return buyBookMapper.findByUserId(userId);
    }

    public List<BuyBook> getAllBuyRecords() {
        return buyBookMapper.findAll();
    }

    public Boolean updateBuyRecord(Integer userId, Integer bookId, Float money, java.sql.Date time) {
        BuyBook buyBook = buyBookMapper.findByUserIdAndBookId(userId, bookId);
        if (buyBook != null) {
            buyBook.setMoney(money);
            buyBook.setTime(time);
            buyBookMapper.update(buyBook);
            return true;
        } else {
            return false;
        }
    }
}