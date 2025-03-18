package com.wuzhaoyan.admin.pojo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;
    private Integer permission; // 权限（0=普通用户，1=会员）

    public User() {}

    public User(String username, String password, Integer permission) {
        this.username = username;
        this.password = password;
        this.permission = permission;
    }
}