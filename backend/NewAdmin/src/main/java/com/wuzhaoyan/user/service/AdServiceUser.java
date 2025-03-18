package com.wuzhaoyan.user.service;

import com.wuzhaoyan.user.pojo.AdUser;
import com.wuzhaoyan.user.repository.AdRepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.Optional;

@Service
public class AdServiceUser {
    @Autowired
    private AdRepositoryUser adRepositoryUser;

    /**
     * 随机获取一个广告
     * @return 包装在 Optional 中的随机广告对象，如果没有广告则返回 Optional.empty()
     */
    public Optional<AdUser> getRandomAd() {
        List<AdUser> adUsers = adRepositoryUser.findAll();
        if (adUsers.isEmpty()) {
            return Optional.empty(); // 如果没有广告，返回 Optional.empty()
        }

        Random random = new Random();
        return Optional.of(adUsers.get(random.nextInt(adUsers.size()))); // 随机返回一个广告
    }
}