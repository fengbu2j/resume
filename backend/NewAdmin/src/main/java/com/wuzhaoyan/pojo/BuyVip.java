package com.wuzhaoyan.pojo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "buyvip")
public class BuyVip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user; // 用户ID，外键

    private Float money; // 购买VIP的金额

    private java.sql.Date time; // 购买时间

    public BuyVip() {}

    public BuyVip(User user, Float money, java.sql.Date time) {
        this.user = user;
        this.money = money;
        this.time = time;
    }
}