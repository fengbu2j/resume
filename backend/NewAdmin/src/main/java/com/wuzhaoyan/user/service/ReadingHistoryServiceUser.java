package com.wuzhaoyan.user.service;

import com.wuzhaoyan.user.pojo.BookUser;
import com.wuzhaoyan.user.pojo.ReadingHistoryUser;
import com.wuzhaoyan.user.pojo.UserUser;
import com.wuzhaoyan.user.repository.BookRepositoryUser;
import com.wuzhaoyan.user.repository.ReadingHistoryRepositoryUser;
import com.wuzhaoyan.user.repository.UserRepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class ReadingHistoryServiceUser {
    @Autowired
    private ReadingHistoryRepositoryUser readingHistoryRepositoryUser;

    @Autowired
    private BookRepositoryUser bookRepositoryUser;

    @Autowired
    private UserRepositoryUser userRepositoryUser;

    // 记录阅读行为
    public Boolean recordReading(Integer userId, Integer bookId) {
        // 检查用户是否存在
        Optional<UserUser> optionalUser = userRepositoryUser.findById(userId);
        if (!optionalUser.isPresent()) {
            return Boolean.FALSE;
        }

        // 检查书籍是否存在
        Optional<BookUser> optionalBook = bookRepositoryUser.findById(bookId);
        if (!optionalBook.isPresent()) {
            return Boolean.FALSE;
        }

        UserUser userUser = optionalUser.get();
        BookUser bookUser = optionalBook.get();

        // 创建新的阅读记录
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        ReadingHistoryUser readingHistoryUser = new ReadingHistoryUser(userUser, bookUser, currentTime);
        readingHistoryRepositoryUser.save(readingHistoryUser);

        // 更新书籍的阅读次数
        bookUser.setNumber(bookUser.getNumber() + 1);
        bookRepositoryUser.save(bookUser);

        return Boolean.TRUE;
    }

    public List<ReadingHistoryUser> getPersonalReadingHistory(Integer userId) {
        return readingHistoryRepositoryUser.findByUserId(userId);
    }
}