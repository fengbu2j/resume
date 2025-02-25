package com.wuzhaoyan.service;

import com.wuzhaoyan.pojo.BuyBook;
import com.wuzhaoyan.repository.BuyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyBookService {
    @Autowired
    private BuyBookRepository buyBookRepository;

    // 查看消费记录
    public List<BuyBook> getBuyRecordsByUserId(Integer userId) {
        return buyBookRepository.findByUserId(userId);
    }

    // 查看所有买书记录
    public List<BuyBook> getAllBuyRecords() {
        return buyBookRepository.findAll();
    }

    // 修改消费记录
    public Boolean updateBuyRecord(Integer userId, Integer bookId, Float money, java.sql.Date time) {
        Optional<BuyBook> optionalBuyBook = buyBookRepository.findByUserIdAndBookId(userId, bookId);
        if (optionalBuyBook.isPresent()) {
            BuyBook buyBook = optionalBuyBook.get();
            buyBook.setMoney(money);
            buyBook.setTime(time);
            buyBookRepository.save(buyBook);
            return true;
        } else {
            return false;
        }
    }
}