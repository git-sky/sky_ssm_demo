package cn.com.sky.spring.transaction.propagation.demo;

import java.util.List;

public interface ICashier {

    void checkout(String username, List<String> isbns);

}