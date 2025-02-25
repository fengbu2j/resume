package com.wuzhaoyan.pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "readinghistory")
public class ReadingHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user; // 用户ID，外键

    @ManyToOne
    @JoinColumn(name = "id_book", referencedColumnName = "id")
    private Book book; // 书籍ID，外键

    private Timestamp time; // 使用 Timestamp 记录年月日时分

    public ReadingHistory() {}

    public ReadingHistory(User user, Book book, Timestamp time) {
        this.user = user;
        this.book = book;
        this.time = time;
    }
}