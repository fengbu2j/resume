package com.wuzhaoyan.user.pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "readinghistory")
public class ReadingHistoryUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private UserUser user; // 用户ID，外键

    @ManyToOne
    @JoinColumn(name = "id_book", referencedColumnName = "id")
    private BookUser bookUser; // 书籍ID，外键

    private Timestamp time; // 使用 Timestamp 记录年月日时分

    public ReadingHistoryUser() {}

    public ReadingHistoryUser(UserUser userUser, BookUser bookUser, Timestamp time) {
        this.user = userUser;
        this.bookUser = bookUser;
        this.time = time;
    }
}