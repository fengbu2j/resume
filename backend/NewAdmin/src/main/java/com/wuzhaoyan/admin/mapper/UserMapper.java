package com.wuzhaoyan.admin.mapper;

import com.wuzhaoyan.admin.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE username = #{username}")
    User findByUsername(String username);

    @Select("SELECT COUNT(*) FROM user")
    long count();

    @Select("SELECT COUNT(*) FROM user WHERE permission = #{permission}")
    long countByPermission(Integer permission);

    @Insert("INSERT INTO user (username, password, permission) VALUES (#{username}, #{password}, #{permission})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user);

    @Update("UPDATE user SET password = #{password}, permission = #{permission} WHERE id = #{id}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    void deleteById(Integer id);

    @Select("SELECT * FROM user WHERE id = #{id}")
    User findById(Integer id);

    @Select("SELECT * FROM user")
    List<User> findAll();
}