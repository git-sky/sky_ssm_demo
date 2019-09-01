package cn.com.sky.spring.transaction.programmatic.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import cn.com.sky.spring.transaction.programmatic.api.dao.BookShopDao;

/**
 * 基于底层 API的编程式事务管理(Spring提供的事务管理 API)
 */
@Service
public class BookShopServiceImpl implements BookShopService {

    @Autowired
    private BookShopDao bookShopDao;
    // 定义事务
    @Autowired
    private TransactionDefinition txDefinition;
    // 事务管理
    @Autowired
    private PlatformTransactionManager txManager;

    @Override
    public void purchase(String username, String isbn) {

        TransactionStatus txStatus = txManager.getTransaction(txDefinition);

        try {

            // 1. 获取书的单价
            int price = bookShopDao.findBookPriceIsdn(isbn);

            // 2. 更新书的库存
            bookShopDao.updateBookStock(isbn);

            // 3. 更新用户余额
            bookShopDao.updateUserAccount(username, price);

            txManager.commit(txStatus);

            System.out.println("purchase success!");

        } catch (Exception e) {
            txManager.rollback(txStatus);
            e.printStackTrace();
            System.out.println("purchase error!");
        }
    }

}