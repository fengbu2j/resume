package com.wuzhaoyan.admin.service;

import com.wuzhaoyan.admin.pojo.Book;
import com.wuzhaoyan.admin.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookMapper bookMapper;

    public List<Book> getAllBooks() {
        return bookMapper.findAll();
    }

    public Book getBookById(Integer id) {
        return bookMapper.findById(id);
    }

    public Book saveBook(Book book) {
        bookMapper.insert(book);
        return book;
    }

    public boolean deleteBook(Integer id) {
        if (bookMapper.existsById(id)) {
            bookMapper.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<Book> getBooksByCategory(Integer category) {
        return bookMapper.findByCategory(category);
    }

    public List<Book> searchBooksByName(String name) {
        return bookMapper.findByNameContaining(name);
    }

    public List<Book> getTopFourBooks() {
        return bookMapper.findTop4ByOrderByNumberDesc();
    }
}