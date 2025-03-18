package com.wuzhaoyan.user.pojo;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ad")
public class AdUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String path;

    public AdUser(){};

    public AdUser(String path){
        this.path=path;
    }
}
