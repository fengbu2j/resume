package com.wuzhaoyan.user.repository;

import com.wuzhaoyan.user.pojo.UserUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryUser extends JpaRepository<UserUser, Integer> {

    UserUser findByUsername(String username);

    Optional<UserUser> findById(Integer id);

    long count();  // 统计用户数

    long countByPermission(Integer permission); // 统计vip的用户数
}