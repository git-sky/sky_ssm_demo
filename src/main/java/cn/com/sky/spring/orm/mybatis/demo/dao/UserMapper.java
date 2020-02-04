package cn.com.sky.spring.orm.mybatis.demo.dao;

import cn.com.sky.spring.orm.mybatis.demo.domain.User;

public interface UserMapper {

    void insertUser(User user);

    User getUserById(Integer id);

    User getUser(String name);
}