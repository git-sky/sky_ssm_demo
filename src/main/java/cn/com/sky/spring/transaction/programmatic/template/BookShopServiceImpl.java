package cn.com.sky.spring.transaction.programmatic.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 基于底层 API的编程式事务管理(Spring提供的事务管理 API)
 */
@Service
public class BookShopServiceImpl implements BookShopService {

    @Autowired
    private BookShopDao bookShopDao;

    @Autowired
    private TransactionTemplate transactionTemplate;

    /*
     * 回滚事务方式一： txStatus.setRollbackOnly();
     */
    @Override
    public void purchase(final String username, final String isbn) {

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {

            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {

            }
        });

        Object obj = transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus txStatus) {
                boolean result = true;
                try {
                    // 1. 获取书的单价
                    int price = bookShopDao.findBookPriceIsdn(isbn);

                    // 2. 更新书的库存
                    bookShopDao.updateBookStock(isbn);

                    // 3. 更新用户余额
                    bookShopDao.updateUserAccount(username, price);

                    System.out.println("purchase success!");

                } catch (Exception e) {
                    txStatus.setRollbackOnly();// 回滚事务
                    result = false;
                    e.printStackTrace();
                    System.out.println("purchase error!");
                }
                return result;
            }
        });

        System.out.println(obj);

    }

    /*
     * 回滚事务方式二： 抛出 unchecked exception 异常
     */
    @Override
    public void purchase2(final String username, final String isbn) {

        Object obj = transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus txStatus) {
                boolean result = true;
                try {
                    // 1. 获取书的单价
                    int price = bookShopDao.findBookPriceIsdn(isbn);

                    // 2. 更新书的库存
                    bookShopDao.updateBookStock(isbn);

                    // 3. 更新用户余额
                    bookShopDao.updateUserAccount(username, price);

                    System.out.println("purchase success!");

                } catch (Exception e) {
                    result = false;
                    e.printStackTrace();
                    System.out.println("purchase error!");
                    throw new RuntimeException(e);// 回滚事务
                }
                return result;
            }
        });

        System.out.println(obj);

    }
}