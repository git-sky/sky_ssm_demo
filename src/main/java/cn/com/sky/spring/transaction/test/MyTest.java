package cn.com.sky.spring.transaction.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sky.spring.transaction.declarative.aopconfig.BookShopService;

/**
 * defaultRollback设置为false，则不回滚。
 */
// @TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class MyTest extends SpringTransactionalContextTests {

    @Autowired
    private BookShopService bookShopService;

    @Test
    public void test() {

        bookShopService.purchase("Lucy", "1001");

    }

}
