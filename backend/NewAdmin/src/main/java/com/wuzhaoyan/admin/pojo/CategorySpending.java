package com.wuzhaoyan.admin.pojo;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class CategorySpending {
    private Integer category;
    private Double totalSpending;


}