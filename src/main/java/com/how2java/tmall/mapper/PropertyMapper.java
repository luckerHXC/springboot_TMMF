package com.how2java.tmall.mapper;
import java.util.List;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Property;
import javafx.beans.property.ListProperty;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PropertyMapper {
    @Select("select * from property ")
    List<Property> findAll();

    @Insert(" insert into property(cid,name) values(#{category.id},#{name})")
    int save(Property property);

    @Delete(" delete from property where id= #{id} ")
    void delete(int id);

    @Select("select * from property where id= #{id} ")
    Property get(int id);

    @Update("update property set name=#{name} where id=#{id}")
    int update(Property property);

    @Select("select name from property where id=#{id}")
    Property findOne(int id);

    @Select("select id from property where name=#{name}")
    int finByname(String name);
    @Select("select * from property where cid=#{cid}")
    List<Property> getBycid(int cid);

    @Select("select * from property where cid=#{category.id}")
    List<Property> findByCategory(Category category);
}
