package com.wuzhaoyan.mapper;

import com.wuzhaoyan.pojo.adminUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface adminMapper {

    @Select("select * from user where name =#{username}")
    adminUser findByName(String username);

    @Insert("insert into user(name,password) values (#{username},#{md5String})")
    void add(String username,String md5String);
}
