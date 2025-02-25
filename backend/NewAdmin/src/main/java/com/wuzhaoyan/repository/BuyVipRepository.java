package com.wuzhaoyan.repository;

import com.wuzhaoyan.pojo.BuyVip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyVipRepository extends JpaRepository<BuyVip, Integer> {
    // 根据用户ID查找VIP购买记录
    List<BuyVip> findByUserId(Integer userId);

    // 查找所有VIP购买记录
    List<BuyVip> findAll();
}