package com.wuzhaoyan.user.repository;

import com.wuzhaoyan.user.pojo.BookUser;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepositoryUser extends JpaRepository<BookUser,Integer> {
    Page<BookUser> findByCategory(Integer category, Pageable pageable);
    List<BookUser> findByNameContaining(String name);@Override
    long count();// 获取所有书籍数目
    // 根据类别返回它们的number总和
    @Query("SELECT category, SUM(number) FROM Book GROUP BY category")
    List<Object[]> getSumNumberByCategory();
    // 获取number最高的四本书
    List<BookUser> findTop4ByOrderByNumberDesc();
}
