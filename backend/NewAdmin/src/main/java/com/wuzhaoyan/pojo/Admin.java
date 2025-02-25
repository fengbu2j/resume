package com.wuzhaoyan.pojo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;

    public Admin() {}

    public Admin(String username, String password, Integer permission) {
        this.username = username;
        this.password = password;
    }
}