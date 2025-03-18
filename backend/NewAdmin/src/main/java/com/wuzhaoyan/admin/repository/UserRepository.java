package com.wuzhaoyan.admin.repository;

import com.wuzhaoyan.admin.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    long count();  // 统计用户数
    long countByPermission(Integer permission); // 统计vip的用户数
}