package com.wuzhaoyan.admin.mapper;

import com.wuzhaoyan.admin.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface BookMapper {
    @Select("SELECT * FROM book WHERE category = #{category}")
    List<Book> findByCategory(Integer category);

    @Select("SELECT * FROM book WHERE name LIKE CONCAT('%', #{name}, '%')")
    List<Book> findByNameContaining(String name);

    @Select("SELECT COUNT(*) FROM book")
    long count();

    @Select("SELECT category, SUM(number) FROM book GROUP BY category")
    List<Object[]> getSumNumberByCategory();

    @Select("SELECT * FROM book ORDER BY number DESC LIMIT 4")
    List<Book> findTop4ByOrderByNumberDesc();

    @Select("SELECT * FROM book")
    List<Book> findAll();

    @Insert("INSERT INTO book (name, category, author, fee, cover, path, money, number) VALUES (#{name}, #{category}, #{author}, #{fee}, #{cover}, #{path}, #{money}, #{number})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Book book);

    @Update("UPDATE book SET name = #{name}, category = #{category}, author = #{author}, fee = #{fee}, cover = #{cover}, path = #{path}, money = #{money}, number = #{number} WHERE id = #{id}")
    void update(Book book);

    @Delete("DELETE FROM book WHERE id = #{id}")
    void deleteById(Integer id);

    @Select("SELECT * FROM book WHERE id = #{id}")
    Book findById(Integer id);

    @Select("SELECT EXISTS(SELECT 1 FROM book WHERE id = #{id})")
    boolean existsById(Integer id);
}