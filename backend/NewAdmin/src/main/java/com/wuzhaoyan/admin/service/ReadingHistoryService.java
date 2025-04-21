package com.wuzhaoyan.admin.service;

import com.wuzhaoyan.admin.pojo.Book;
import com.wuzhaoyan.admin.pojo.ReadingHistory;
import com.wuzhaoyan.admin.pojo.User;
import com.wuzhaoyan.admin.mapper.BookMapper;
import com.wuzhaoyan.admin.mapper.ReadingHistoryMapper;
import com.wuzhaoyan.admin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ReadingHistoryService {
    @Autowired
    private ReadingHistoryMapper readingHistoryMapper;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private UserMapper userMapper;

    public Boolean recordReading(Integer userId, Integer bookId) {
        User user = userMapper.findById(userId);
        if (user == null) {
            return false;
        }

        Book book = bookMapper.findById(bookId);
        if (book == null) {
            return false;
        }

        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        ReadingHistory readingHistory = new ReadingHistory();
        readingHistory.setUser(user);
        readingHistory.setBook(book);
        readingHistory.setTime(currentTime);
        readingHistoryMapper.insert(readingHistory);

        book.setNumber(book.getNumber() + 1);
        bookMapper.update(book);

        return true;
    }

    public List<ReadingHistory> getPersonalReadingHistory(Integer userId) {
        return readingHistoryMapper.findByUserId(userId);
    }
}