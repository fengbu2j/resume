package com.wuzhaoyan.admin.repository;

import com.wuzhaoyan.admin.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    List<Book> findByCategory(Integer category);
    List<Book> findByNameContaining(String name);@Override
    long count();// 获取所有书籍数目
    // 根据类别返回它们的number总和
    @Query("SELECT category, SUM(number) FROM Book GROUP BY category")
    List<Object[]> getSumNumberByCategory();
    // 获取number最高的四本书
    List<Book> findTop4ByOrderByNumberDesc();


}
