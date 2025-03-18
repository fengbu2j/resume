package com.wuzhaoyan.user.pojo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "buyvip")
public class BuyVipUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private UserUser user; // 用户ID，外键

    private Float money; // 购买VIP的金额

    private java.sql.Date time; // 购买时间

    public BuyVipUser() {}

    public BuyVipUser(UserUser userUser, Float money, java.sql.Date time) {
        this.user = userUser;
        this.money = money;
        this.time = time;
    }
}