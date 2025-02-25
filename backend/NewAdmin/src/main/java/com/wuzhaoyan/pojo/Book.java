package com.wuzhaoyan.pojo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Book {
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

    public Book(){ }

    public Book(String name,
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
