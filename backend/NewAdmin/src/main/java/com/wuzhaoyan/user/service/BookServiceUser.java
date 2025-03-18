package com.wuzhaoyan.user.service;

import com.wuzhaoyan.user.pojo.BookUser;
import com.wuzhaoyan.user.repository.BookRepositoryUser;
import com.wuzhaoyan.user.repository.UserRepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookServiceUser {
    @Autowired
    private BookRepositoryUser bookRepositoryUser;
    @Autowired
    private UserRepositoryUser userRepositoryUser;

    public List<BookUser> getAllBooks() {
        return bookRepositoryUser.findAll();
    }

    public BookUser getBookById(Integer id) {
        return bookRepositoryUser.findById(id).orElse(null);
    }


    public Page<BookUser> getBooksByCategory(Integer category, int page) {
        // 每页返回5本书
        Pageable pageable = PageRequest.of(page, 5);
        return bookRepositoryUser.findByCategory(category, pageable);
    }

    public List<BookUser> searchBooksByName(String name) {
        return bookRepositoryUser.findByNameContaining(name);
    }

    public Map<Integer, Float> getMoneyCountByCategory() {
        List<BookUser> bookUsers = bookRepositoryUser.findAll();
        return bookUsers.stream()
                .filter(book -> book.getCategory() != null && book.getMoney() != null)
                .collect(Collectors.groupingBy(
                        BookUser::getCategory,
                        Collectors.summingDouble(book -> book.getMoney())  // 使用 summingDouble
                )).entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().floatValue()  // 转换为 Float
                ));
    }


    public Map<Integer, Integer> getNumberCountByCategory() {
        List<BookUser> bookUsers = bookRepositoryUser.findAll();
        return bookUsers.stream()
                .filter(book -> book.getCategory() != null && book.getNumber() != null)
                .collect(Collectors.groupingBy(
                        BookUser::getCategory,
                        Collectors.summingDouble(book -> book.getNumber().doubleValue())  // 使用 doubleValue()
                )).entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().intValue()  // 转换为 Integer
                ));
    }

    // 获取number最高的四本书作为推荐书籍
    public List<BookUser> getTopFourBooks() {
        return bookRepositoryUser.findTop4ByOrderByNumberDesc();
    }

    public String generatePaymentCode(Float money) {
        // 模拟生成收款码的逻辑
        String paymentCode = "payment_code_" + UUID.randomUUID().toString() + "_money_" + money;
        return paymentCode;
    }
}


//    // 获取用户可访问的书籍列表
//    public List<Book> getAccessibleBooks() {
//        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User user = userRepository.findByName(authentication.getName());
//
//        return bookRepository.findAll().stream()
//                .filter(book -> {
//                    if (user.getPermission() == 1) { // VIP用户
//                        return book.getFee() != 2; // VIP可以访问fee=0和fee=1的书籍
//                    } else { // 普通用户
//                        return book.getFee() == 0; // 普通用户只能访问fee=0的书籍
//                    }
//                })
//                .toList();
//    }

//    // 检查用户是否有权限访问某本书
//    public boolean canAccessBook(Book book) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User user = userRepository.findByName(authentication.getName());
//
//        if (user.getPermission() == 1) { // VIP用户
//            return book.getFee() != 2; // VIP可以访问fee=0和fee=1的书籍
//        } else { // 普通用户
//            return book.getFee() == 0; // 普通用户只能访问fee=0的书籍
//        }
//

