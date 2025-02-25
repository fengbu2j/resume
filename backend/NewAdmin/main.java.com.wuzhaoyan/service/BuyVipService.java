package com.wuzhaoyan.service;

import com.wuzhaoyan.pojo.BuyVip;
import com.wuzhaoyan.pojo.User;
import com.wuzhaoyan.repository.BuyVipRepository;
import com.wuzhaoyan.repository.UserRepository;
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
    public String buyVip(Integer userId, Float money, java.sql.Date time) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setPermission(1); // 将用户权限设置为会员
            userRepository.save(user);

            BuyVip buyVip = new BuyVip(user, money, time);
            buyVipRepository.save(buyVip);
            return "VIP购买成功";
        } else {
            return "用户不存在";
        }
    }
}