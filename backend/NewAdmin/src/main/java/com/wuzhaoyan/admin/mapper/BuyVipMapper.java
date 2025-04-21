package com.wuzhaoyan.admin.mapper;

import com.wuzhaoyan.admin.pojo.BuyVip;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface BuyVipMapper {
    @Select("SELECT * FROM buyvip WHERE id_user = #{userId}")
    List<BuyVip> findByUserId(Integer userId);

    @Select("SELECT * FROM buyvip")
    List<BuyVip> findAll();

    @Insert("INSERT INTO buyvip (id_user, time, money) VALUES (#{id_user}, #{time}, #{money})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(BuyVip buyVip);

    @Delete("DELETE FROM buyvip WHERE id = #{id}")
    void deleteById(Integer id);

}