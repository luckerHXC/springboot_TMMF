package com.how2java.tmall.mapper;

import org.springframework.data.jpa.repository.JpaRepository;

import com.how2java.tmall.pojo.User;

public interface UserMapper extends JpaRepository<User,Integer>{

}