package com.how2java.tmall.service;
import java.util.List;

import com.how2java.tmall.mapper.CategoryMapper;
import com.how2java.tmall.mapper.PropertyMapper;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {
    @Autowired PropertyMapper propertyMapper;
    @Autowired CategoryMapper categoryMapper;

    public List<Property> list(int cid){
        Category category = categoryMapper.get(cid);
        List<Property> properties=propertyMapper.getBycid(category.id);
        return properties;
    }
    public void add(Property bean) {

        propertyMapper.save(bean);
    }
    public void delete(int id) {

        propertyMapper.delete(id);
    }
    public Property get(int id) {

        Property p= propertyMapper.findOne(id);
        return p;
    }
    public void update(Property bean) {

        propertyMapper.update(bean);
    }
    public int findByname(String name){

        int id=propertyMapper.finByname(name);
        return id;
    }
    public List<Property> listByCategory(Category category){
        return propertyMapper.findByCategory(category);
    }


}
