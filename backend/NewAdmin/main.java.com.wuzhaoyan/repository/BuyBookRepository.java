package com.wuzhaoyan.repository;

import com.wuzhaoyan.pojo.BuyBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BuyBookRepository extends JpaRepository<BuyBook, Integer> {
    // 根据用户ID查找消费记录
    List<BuyBook> findByUserId(Integer userId);
    // 根据记录ID查找消费记录
    BuyBook findByBookId(Integer id);
    // 根据用户ID和记录ID查找消费记录
    Optional<BuyBook> findByUserIdAndBookId(Integer userId, Integer bookId);
    // 查找所有买书记录
    List<BuyBook> findAll();
    // 根据类别统计消费金额
    @Query("SELECT b.book.category, SUM(b.money) FROM BuyBook b GROUP BY b.book.category ORDER BY b.book.category ASC")
    List<Object[]> getTotalSpendingByCategory();
}