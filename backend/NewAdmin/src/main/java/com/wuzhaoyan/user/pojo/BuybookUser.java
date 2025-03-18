package com.wuzhaoyan.user.pojo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "BuyBook")
public class BuybookUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_book", referencedColumnName = "id")
    private BookUser book; // 书籍ID，外键

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private UserUser user; // 用户ID，外键

    private Float money;

    private java.sql.Date time;

    public BuybookUser() {}

    public BuybookUser(BookUser bookUser, UserUser userUser, Float money, java.sql.Date time) {
        this.book = bookUser;
        this.user = userUser;
        this.money = money;
        this.time = time;
    }
}