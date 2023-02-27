package com.how2java.tmall.mapper;
import java.util.List;
import com.how2java.tmall.pojo.Product;
import org.apache.ibatis.annotations.*;


@Mapper
public interface ProductMapper {
    @Select("select * from product ")
    List<Product> findAll();

    @Insert(" insert into product(name,subTitle,originalPrice,promotePrice,stock,cid,createDate) values(#{name},#{subTitle},#{originalPrice},#{promotePrice},#{stock},#{category.id},#{createDate})")
    int save(Product product);

    @Delete(" delete from product where id= #{id} ")
    void delete(int id);

    @Select("select * from product where id=#{id}")
    Product get(int id);

    @Update("update product set name=#{name},subTitle=#{subTitle},originalPrice=#{originalPrice},promotePrice=#{promotePrice},stock=#{stock} where id=#{id}")
    int update(Product product);

    @Select("select name from product where id=#{id}")
    Product findOne(int id);

    @Select("select id from product where name=#{name}")
    int finByname(String name);

    @Select("select * from product where cid=#{cid} ")
    List<Product> getBycid(int cid);
}
