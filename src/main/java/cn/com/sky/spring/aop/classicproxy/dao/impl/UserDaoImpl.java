package cn.com.sky.spring.aop.classicproxy.dao.impl;

import cn.com.sky.spring.aop.classicproxy.dao.UserDao;

public class UserDaoImpl implements UserDao {

    @Override
    public void add() {
        System.out.println("add...");

    }

    @Override
    public void delete() {
        System.out.println("delete...");

    }

    @Override
    public void update() {
        System.out.println("update...");

    }

    @Override
    public void query() {
        System.out.println("query...");
    }

    @Override
    public String query(String id) {
        System.out.println("query id");
        return "query";
    }

    @Override
    public void test() throws Exception {
        System.out.println("test...");
        throw new Exception();
    }

}
