package com.how2java.tmall.service;
import java.util.List;

import com.how2java.tmall.mapper.CategoryMapper;
import com.how2java.tmall.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;


@Service
@CacheConfig(cacheNames="categories")
public class CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Cacheable(key="'categories-all'")
    public List<Category> list(){
        return categoryMapper.findAll();
    }
    @CacheEvict(allEntries=true)
    public void add(Category bean) {
        categoryMapper.save(bean);
    }
    @CacheEvict(allEntries=true)
    public void delete(int id) {
        categoryMapper.delete(id);
    }
    @Cacheable(key="'categories-one-'+ #p0")
    public Category get(int id) {
        Category c= categoryMapper.findOne(id);
        return c;
    }
    @CacheEvict(allEntries=true)
    public void update(Category bean) {
        categoryMapper.update(bean);
    }
    @CacheEvict(allEntries=true)
    public int findByname(String name){
        int id=categoryMapper.finByname(name);
        return id;
    }

}
