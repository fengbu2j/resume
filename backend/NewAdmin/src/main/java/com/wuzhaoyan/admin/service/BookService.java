package com.wuzhaoyan.admin.service;

import com.wuzhaoyan.admin.pojo.Book;
import com.wuzhaoyan.admin.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public boolean deleteBook(Integer id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<Book> getBooksByCategory(Integer category) {

        return bookRepository.findByCategory(category);
    }


    public List<Book> searchBooksByName(String name) {
        return bookRepository.findByNameContaining(name);
    }

    // 获取number最高的四本书作为推荐书籍
    public List<Book> getTopFourBooks() {
        return bookRepository.findTop4ByOrderByNumberDesc();
    }
}
