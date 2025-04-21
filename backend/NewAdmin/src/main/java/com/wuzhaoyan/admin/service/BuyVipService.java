package com.wuzhaoyan.admin.service;

import com.wuzhaoyan.admin.pojo.BuyVip;
import com.wuzhaoyan.admin.pojo.User;
import com.wuzhaoyan.admin.mapper.BuyVipMapper;
import com.wuzhaoyan.admin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyVipService {
    @Autowired
    private BuyVipMapper buyVipMapper;

    @Autowired
    private UserMapper userMapper;

    public List<BuyVip> getBuyVipRecordsByUserId(Integer userId) {
        return buyVipMapper.findByUserId(userId);
    }

    public List<BuyVip> getAllBuyVipRecords() {
        return buyVipMapper.findAll();
    }

    public Boolean buyVip(Integer userId, Float money, java.sql.Date time) {
        User user = userMapper.findById(userId);
        if (user != null) {
            user.setPermission(1); // 将用户权限设置为会员
            userMapper.update(user);

            BuyVip buyVip = new BuyVip();
            buyVip.setUser(user);
            buyVip.setTime(time);
            buyVip.setMoney(money);
            buyVipMapper.insert(buyVip);
            return true;
        } else {
            return false;
        }
    }
}