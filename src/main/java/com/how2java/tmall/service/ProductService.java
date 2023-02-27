package com.how2java.tmall.service;


import com.how2java.tmall.mapper.CategoryMapper;
import com.how2java.tmall.mapper.ProductMapper;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService  {

    @Autowired ProductMapper productMapper;
    @Autowired CategoryMapper categoryMapper;

    public void add(Product bean) {
        productMapper.save(bean);
    }

    public void delete(int id) {
        productMapper.delete(id);
    }

    public Product get(int id) {
        return productMapper.get(id);
    }

    public void update(Product bean) {
        productMapper.save(bean);
    }

    public List<Product> list(int cid){
        Category category = categoryMapper.get(cid);
        List<Product> properties=productMapper.getBycid(category.id);
        return properties;
    }

}