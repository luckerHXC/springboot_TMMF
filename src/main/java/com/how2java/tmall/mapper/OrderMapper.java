package com.how2java.tmall.mapper;
import java.util.List;

import com.how2java.tmall.pojo.Order;
import com.how2java.tmall.pojo.OrderItem;
import com.how2java.tmall.pojo.Product;
import org.apache.ibatis.annotations.*;


@Mapper
public interface OrderMapper {
    @Select("select * from order_ ")
    List<Order> findAll();

    @Select("select * from order_ where id=#{id}")
    Order get(int id);

    @Select("select name from order_ where id=#{id}")
    Order findOne(int id);

    @Select("select id from order_ where name=#{name}")
    int finByname(String name);

    @Select("select * from order_ where cid=#{cid} ")
    List<Order> getBycid(int cid);

    @Update("update order_ set status=#{order.status} where id=#{id}")
    int save(Order order);
}