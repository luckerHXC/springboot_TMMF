package com.how2java.tmall.mapper;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.Property;
import com.how2java.tmall.pojo.PropertyValue;
import org.apache.ibatis.annotations.*;
import java.util.List;
@Mapper
public interface PropertyValueMappper {
    @Select("select * from propertyvalue ")
    List<PropertyValue> findAll();

    @Select("select * from propertyvalue where id= #{id} ")
    PropertyValue get(int id);

    @Update("update propertyvalue set pid=#{pid},ptid=#{ptid},value=#{value} where id=#{id}")
    void update(PropertyValue propertyValue);

    @Insert("insert into propertyvalue(pid,ptid,value) values(#{pid},#{ptid},#{value})")
    void save(PropertyValue propertyValue);

    @Select("select * from propertyvaluewhere ptid=#{ptid}")
    PropertyValue finByptid(int ptid);

    @Select("select * from propertyvaluewhere value=#{value}")
    PropertyValue findByvalue(String value);

    @Select("select * from propertyvalue where pid= #{pid}")
    List<PropertyValue> getBypid(int pid);

    @Select("select * from propertyvalue where pid=#{product.id} and ptid=#{property.id}")
    PropertyValue getByPropertyAndProduct(@Param("product") Product product,@Param("property") Property property);

    @Select("select * from propertyvalue where pid=#{product.id} order by id Desc")
    List<PropertyValue> findByProductOrderByIdDesc(@Param("product")Product product);
}
