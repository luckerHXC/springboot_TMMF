package com.how2java.tmall.mapper;
import java.util.List;

import com.how2java.tmall.pojo.OrderItem;
import com.how2java.tmall.pojo.Order;
import org.apache.ibatis.annotations.*;


@Mapper
public interface OrderItemMapper {
    @Select("select * from orderitem ")
    List<OrderItem> findAll();


    @Select("select * from orderitem where id=#{id}")
    OrderItem get(int id);

    @Select("select name from orderitem where id=#{id}")
    OrderItem findOne(int id);

    @Select("select id from orderitem where name=#{name}")
    int finByname(String name);

    @Select("select * from orderitem where cid=#{cid} ")
    List<OrderItem> getBycid(int cid);

    @Select("select * from orderitem where oid=#{order.id}")
    List<OrderItem> findByOrderOrderByIdDesc(@Param("order") Order order);
}