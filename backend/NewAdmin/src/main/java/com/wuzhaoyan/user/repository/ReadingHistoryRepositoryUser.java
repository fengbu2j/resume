package com.wuzhaoyan.user.repository;

import com.wuzhaoyan.user.pojo.ReadingHistoryUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReadingHistoryRepositoryUser extends JpaRepository<ReadingHistoryUser, Integer> {
    // 根据用户ID查找所有阅读记录
    List<ReadingHistoryUser> findByUserId(Integer userId);
}