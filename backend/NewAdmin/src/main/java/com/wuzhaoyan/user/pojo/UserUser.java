package com.wuzhaoyan.user.pojo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class UserUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;
    private Integer permission; // 权限（0=普通用户，1=会员）

    public UserUser() {}

    public UserUser(String username, String password, Integer permission) {
        this.username = username;
        this.password = password;
        this.permission = permission;
    }
}