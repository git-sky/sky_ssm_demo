package cn.com.sky.spring.transaction.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sky.spring.transaction.declarative.aopconfig.BookShopService;

public class MyTest2 extends SpringContextTests {

    @Autowired
    private BookShopService bookShopService;

    @Test
    public void test() {

        bookShopService.purchase("Lucy", "1001");

    }

}
