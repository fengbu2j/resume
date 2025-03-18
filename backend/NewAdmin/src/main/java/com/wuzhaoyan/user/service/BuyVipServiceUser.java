package com.wuzhaoyan.user.service;

import com.wuzhaoyan.user.pojo.BuyVipUser;
import com.wuzhaoyan.user.pojo.UserUser;
import com.wuzhaoyan.user.repository.BuyVipRepositoryUser;
import com.wuzhaoyan.user.repository.UserRepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyVipServiceUser {
    @Autowired
    private BuyVipRepositoryUser buyVipRepositoryUser;

    @Autowired
    private UserRepositoryUser userRepositoryUser;

    // 查看VIP购买记录
    public List<BuyVipUser> getBuyVipRecordsByUserId(Integer userId) {
        return buyVipRepositoryUser.findByUserId(userId);
    }

    // 查看所有VIP购买记录
    public List<BuyVipUser> getAllBuyVipRecords() {
        return buyVipRepositoryUser.findAll();
    }

    // 购买VIP
    public Boolean buyVip(Integer userId, Float money, java.sql.Date time) {
        Optional<UserUser> optionalUser = userRepositoryUser.findById(userId);
        if (optionalUser.isPresent()) {
            UserUser userUser = optionalUser.get();
            userUser.setPermission(1); // 将用户权限设置为会员
            userRepositoryUser.save(userUser);

            BuyVipUser buyVipUser = new BuyVipUser(userUser, money, time);
            buyVipRepositoryUser.save(buyVipUser);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
}