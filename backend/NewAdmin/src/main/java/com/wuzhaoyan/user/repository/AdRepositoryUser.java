package com.wuzhaoyan.user.repository;

import com.wuzhaoyan.user.pojo.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdRepositoryUser extends JpaRepository<AdUser, Integer> {
}