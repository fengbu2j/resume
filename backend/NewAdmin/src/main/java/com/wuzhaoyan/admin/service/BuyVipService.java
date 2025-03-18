package com.wuzhaoyan.admin.service;

import com.wuzhaoyan.admin.pojo.BuyVip;
import com.wuzhaoyan.admin.pojo.User;
import com.wuzhaoyan.admin.repository.BuyVipRepository;
import com.wuzhaoyan.admin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyVipService {
    @Autowired
    private BuyVipRepository buyVipRepository;

    @Autowired
    private UserRepository userRepository;

    // 查看VIP购买记录
    public List<BuyVip> getBuyVipRecordsByUserId(Integer userId) {
        return buyVipRepository.findByUserId(userId);
    }

    // 查看所有VIP购买记录
    public List<BuyVip> getAllBuyVipRecords() {
        return buyVipRepository.findAll();
    }

    // 购买VIP
    public Boolean buyVip(Integer userId, Float money, java.sql.Date time) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setPermission(1); // 将用户权限设置为会员
            userRepository.save(user);

            BuyVip buyVip = new BuyVip(user, money, time);
            buyVipRepository.save(buyVip);
            return true;
        } else {
            return false;
        }
    }
}