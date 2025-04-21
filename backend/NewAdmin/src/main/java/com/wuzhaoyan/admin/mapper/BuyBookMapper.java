package com.wuzhaoyan.admin.mapper;

import com.wuzhaoyan.admin.pojo.BuyBook;
import com.wuzhaoyan.admin.pojo.CategorySpending;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface BuyBookMapper {
    @Select("SELECT * FROM buybook WHERE id_user = #{userId}")
    List<BuyBook> findByUserId(Integer userId);

    @Select("SELECT * FROM buybook WHERE id_book = #{id}")
    BuyBook findByBookId(Integer id);

    @Select("SELECT * FROM buybook WHERE id_user = #{userId} AND id_book = #{bookId}")
    BuyBook findByUserIdAndBookId(Integer userId, Integer bookId);

    @Select("SELECT * FROM buybook")
    List<BuyBook> findAll();

    @Select("SELECT b.category, COALESCE(SUM(bb.money), 0) AS totalSpending " +
            "FROM book b " +
            "JOIN buybook bb ON b.id = bb.id_book " +
            "GROUP BY b.category")
    List<CategorySpending> getTotalSpendingByCategory();

    @Insert("INSERT INTO buybook (id_book, id_user, money, time) VALUES (#{idBook}, #{idUser}, #{money}, #{time})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(BuyBook buyBook);

    @Update("UPDATE buybook SET money = #{money}, time = #{time} WHERE id = #{id}")
    void update(BuyBook buyBook);

    @Delete("DELETE FROM buybook WHERE id = #{id}")
    void deleteById(Integer id);
}