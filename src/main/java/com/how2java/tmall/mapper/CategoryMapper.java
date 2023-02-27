package com.how2java.tmall.mapper;
import java.util.List;
import com.how2java.tmall.pojo.Category;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CategoryMapper {
    @Select("select * from category ")
    List<Category> findAll();

    @Insert(" insert into category( name ) values (#{name}) ")
    int save(Category category);

    @Delete(" delete from category where id= #{id} ")
     void delete(int id);

    @Select("select * from category where id= #{id} ")
     Category get(int id);

    @Update("update category set name=#{name} where id=#{id} ")
     int update(Category category);

    @Select("select name from category where id=#{id}")
     Category findOne(int id);

    @Select("select id from category where name=#{name}")
    int finByname(String name);


}
