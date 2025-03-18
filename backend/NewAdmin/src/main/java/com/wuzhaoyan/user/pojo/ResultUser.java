package com.wuzhaoyan.user.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResultUser<T> {
    private Integer code;   //是否成功
    private String message;  //提示
    private T data;  //响应数据

    public  static <E> ResultUser<E> success(E data)
    {
        return new ResultUser<>(0,"操作成功",data);
    }

    public static ResultUser success()
    {
        return new ResultUser(0,"操作成功",null);
    }

    public static ResultUser error(String message){
        return new ResultUser(1,message,null);
    }

}
