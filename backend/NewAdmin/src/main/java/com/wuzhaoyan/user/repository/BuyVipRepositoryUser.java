package com.wuzhaoyan.user.repository;

import com.wuzhaoyan.user.pojo.BuyVipUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyVipRepositoryUser extends JpaRepository<BuyVipUser, Integer> {
    // 根据用户ID查找VIP购买记录
    List<BuyVipUser> findByUserId(Integer userId);

    // 查找所有VIP购买记录
    List<BuyVipUser> findAll();
}