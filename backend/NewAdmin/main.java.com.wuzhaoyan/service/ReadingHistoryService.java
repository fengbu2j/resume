package com.wuzhaoyan.service;

import com.wuzhaoyan.pojo.Book;
import com.wuzhaoyan.pojo.ReadingHistory;
import com.wuzhaoyan.pojo.User;
import com.wuzhaoyan.repository.BookRepository;
import com.wuzhaoyan.repository.ReadingHistoryRepository;
import com.wuzhaoyan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class ReadingHistoryService {
    @Autowired
    private ReadingHistoryRepository readingHistoryRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    // 记录阅读行为
    public Boolean recordReading(Integer userId, Integer bookId) {
        // 检查用户是否存在
        Optional<User> optionalUser = userRepository.findById(userId);
        if (!optionalUser.isPresent()) {
            return false;
        }

        // 检查书籍是否存在
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (!optionalBook.isPresent()) {
            return false;
        }

        User user = optionalUser.get();
        Book book = optionalBook.get();

        // 创建新的阅读记录
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        ReadingHistory readingHistory = new ReadingHistory(user, book, currentTime);
        readingHistoryRepository.save(readingHistory);

        // 更新书籍的阅读次数
        book.setNumber(book.getNumber() + 1);
        bookRepository.save(book);

        return true;
    }

    public List<ReadingHistory> getPersonalReadingHistory(Integer userId) {
        return readingHistoryRepository.findByUserId(userId);
    }
}