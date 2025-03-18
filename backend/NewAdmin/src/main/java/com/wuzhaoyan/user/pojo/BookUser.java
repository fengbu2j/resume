package com.wuzhaoyan.user.pojo;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "book")
public class BookUser {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer category;
    private String author;
    private Integer fee;
    private String cover;
    private String path;
    private Float money;
    private Integer number;

    public BookUser(){ }

    public BookUser(String name,
                    Integer category,
                    String author,
                    Integer fee,
                    String cover,
                    String path,
                    Float money,
                    Integer number){
        this.name=name;
        this.category=category;
        this.author=author;
        this.fee = fee;
        this.cover=cover;
        this.path=path;
        this.money=money;
        this.number=number;
    }


}
