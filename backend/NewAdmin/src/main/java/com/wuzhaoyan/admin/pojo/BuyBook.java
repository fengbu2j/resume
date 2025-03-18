package com.wuzhaoyan.admin.pojo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "buybook")
public class BuyBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_book", referencedColumnName = "id")
    private Book book; // 书籍ID，外键

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user; // 用户ID，外键

    private Float money;

    private java.sql.Date time;

    public BuyBook() {}

    public BuyBook(Book book, User user, Float money, java.sql.Date time) {
        this.book = book;
        this.user = user;
        this.money = money;
        this.time = time;
    }
}