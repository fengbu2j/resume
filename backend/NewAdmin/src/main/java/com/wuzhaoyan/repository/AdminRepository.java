package com.wuzhaoyan.repository;

import com.wuzhaoyan.pojo.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findByUsername(String username); // 根据用户名查找管理员
}