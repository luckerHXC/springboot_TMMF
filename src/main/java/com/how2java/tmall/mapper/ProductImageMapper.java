package com.how2java.tmall.mapper;
import java.util.List;

import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.ProductImage;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ProductImageMapper {
    @Select("select * from productimage ")
    List<ProductImage> findAll();

    @Insert(" insert into productimage(pid,type) values(#{product.id},#{type})")
    int save(ProductImage productImage);

    @Delete(" delete from productimage where id= #{id} ")
    void delete(int id);

    @Select("select * from productimage where id= #{id} ")
    ProductImage get(int id);

    @Update("update productimage set pid=#{pid},type=#{type} where id=#{id}")
    int update(ProductImage productImage);

    @Select("select type from productimage where id=#{id}")
    ProductImage findOne(int id);

    @Select("select id from productimage where type=#{type}")
    int finBytype(String type);

    @Select("select id from productimage where pid=#{product.id} ")
    int[] getBypid(@Param("product")Product product);

    @Select("select * from productimage where pid=#{product.id} and type=#{type}")
    List<ProductImage> findByProductAndTypeOrderByIdDesc(@Param("product")Product product,@Param("type")String type);
}
