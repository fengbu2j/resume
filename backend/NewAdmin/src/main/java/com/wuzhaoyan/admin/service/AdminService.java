package com.wuzhaoyan.admin.service;

import com.wuzhaoyan.admin.pojo.Admin;
import com.wuzhaoyan.admin.repository.AdminRepository;
import com.wuzhaoyan.admin.utils.BloomFilter;
import com.wuzhaoyan.admin.utils.HashFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    private BloomFilter<String> bloomFilter;

    public AdminService() {
        // 初始化布隆过滤器，指定位数组大小和哈希函数
        bloomFilter = new BloomFilter<>(
                10000, // 位数组大小
                new Function[]{
                        HashFunctions.hashFunction1,
                        HashFunctions.hashFunction2,
                        HashFunctions.hashFunction3
                }
        );

        // 初始化时加载所有管理员用户名到布隆过滤器
        adminRepository.findAll().forEach(admin -> bloomFilter.add(admin.getUsername()));
    }

    // 管理员登录
    public Admin login(String username, String password) {
        // 使用布隆过滤器快速判断用户名是否存在
        if (!bloomFilter.mightContain(username)) {
            return null; // 用户名不存在
        }

        Admin admin = adminRepository.findByUsername(username);
        if (admin != null && admin.getPassword().equals(password)) {
            return admin; // 登录成功
        }
        return null; // 登录失败
    }

    // 在添加管理员时，将用户名添加到布隆过滤器
    public void addAdmin(Admin admin) {
        adminRepository.save(admin);
        bloomFilter.add(admin.getUsername());
    }
}