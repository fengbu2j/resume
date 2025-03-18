package com.wuzhaoyan.admin.repository;

import com.wuzhaoyan.admin.pojo.ReadingHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReadingHistoryRepository extends JpaRepository<ReadingHistory, Integer> {
    // 根据用户ID查找所有阅读记录
    List<ReadingHistory> findByUserId(Integer userId);
}