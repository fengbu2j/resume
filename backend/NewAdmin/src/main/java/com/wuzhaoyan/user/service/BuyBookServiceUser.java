package com.wuzhaoyan.user.service;

import com.wuzhaoyan.admin.pojo.Book;
import com.wuzhaoyan.admin.pojo.User;
import com.wuzhaoyan.user.pojo.BookUser;
import com.wuzhaoyan.user.pojo.BuybookUser;
import com.wuzhaoyan.user.pojo.UserUser;
import com.wuzhaoyan.user.repository.BookRepositoryUser;
import com.wuzhaoyan.user.repository.BuyBookRepositoryUser;
import com.wuzhaoyan.user.repository.UserRepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyBookServiceUser {
    @Autowired
    private BuyBookRepositoryUser buyBookRepositoryUser;
    @Autowired
    private BookRepositoryUser bookRepositoryUser;
    @Autowired
    private UserRepositoryUser userRepositoryUser;

    // 查看消费记录
    public List<BuybookUser> getBuyRecordsByUserId(Integer userId) {
        return buyBookRepositoryUser.findByUserId(userId);
    }

    // 查看所有买书记录
    public List<BuybookUser> getAllBuyRecords() {
        return buyBookRepositoryUser.findAll();
    }

    // 添加消费记录
    public Boolean updateBuyRecord(Integer userId, Integer bookId, Float money, java.sql.Date time) {
        Optional<BuybookUser> optionalBuyBook = buyBookRepositoryUser.findByUserIdAndBookId(userId, bookId);
        if (optionalBuyBook.isPresent()) {
            return Boolean.FALSE;
        } else {
            Optional<BookUser> book = bookRepositoryUser.findById(bookId);
            Optional<UserUser> user = userRepositoryUser.findById(userId);
            if (book.isPresent() && user.isPresent()) {
                // 创建BuyBook实体
                BuybookUser buyBook = new BuybookUser();
                buyBook.setUser(user.get());  // 设置用户
                buyBook.setBook(book.get());  // 设置书籍
                buyBook.setMoney(money);      // 设置价格
                buyBook.setTime(time);        // 设置时间

                // 保存到数据库
                buyBookRepositoryUser.save(buyBook);
                return true;
            } else {
                // 如果用户或书籍不存在，返回false
                return false;
            }
        }
    }
}