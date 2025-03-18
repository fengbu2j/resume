package com.wuzhaoyan.user.repository;

import com.wuzhaoyan.admin.pojo.BuyBook;
import com.wuzhaoyan.user.pojo.BuybookUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BuyBookRepositoryUser extends JpaRepository<BuybookUser, Integer> {
    // 根据用户ID查找消费记录
    List<BuybookUser> findByUserId(Integer userId);
    // 根据记录ID查找消费记录
    Optional<BuybookUser> findById(Integer id);

    // 查找所有买书记录
    List<BuybookUser> findAll();
    Optional<BuybookUser> findByUserIdAndBookId(Integer userId, Integer bookId);
    // 根据类别统计消费金额
    @Query("SELECT b.book.category, SUM(b.money) FROM BuyBook b GROUP BY b.book.category")
    List<Object[]> getTotalSpendingByCategory();
}