package com.wuzhaoyan.admin.mapper;

import com.wuzhaoyan.admin.pojo.ReadingHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

@Mapper
public interface ReadingHistoryMapper {
    @Select("SELECT * FROM readinghistory WHERE id_user = #{userId}")
    List<ReadingHistory> findByUserId(Integer userId);

    @Insert("INSERT INTO readinghistory (id_user, id_book, time) VALUES (#{id_user}, #{id_book}, #{time})")
    void insert(ReadingHistory readingHistory);
}