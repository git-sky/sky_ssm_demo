package cn.com.sky.spring.transaction.declarative.aopconfig;

import java.util.List;

public interface Cashier {

    void checkout(String username, List<String> isbns);

}