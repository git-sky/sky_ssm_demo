package cn.com.sky.spring.transaction.programmatic.template;

import java.beans.PropertyVetoException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestTemplate {

    static String user = "root";
    static String password = "root";
    static String jdbcUrl = "jdbc:mysql://localhost:3306/springjdbc?characterEncoding=utf8&amp;zeroDateTimeBehavior=convertToNull&amp;allowMultiQueries=true";
    static String driverClass = "com.mysql.jdbc.Driver";
    static int initPoolSize = 3;
    static int maxPoolSize = 10;

    public static void main(String[] args) throws PropertyVetoException {

        ComboPooledDataSource datasource = new com.mchange.v2.c3p0.ComboPooledDataSource();
        datasource.setUser(user);
        datasource.setPassword(password);
        datasource.setJdbcUrl(jdbcUrl);
        datasource.setDriverClass(driverClass);
        datasource.setInitialPoolSize(initPoolSize);
        datasource.setMaxPoolSize(maxPoolSize);

        final JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        DataSourceTransactionManager txManager = new DataSourceTransactionManager(datasource);

        TransactionTemplate txTemplate = new TransactionTemplate(txManager);

        Object obj = txTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus txStatus) {
                int i = 0;
                try {

                    String username = "Lucy";
                    String isbn = "1001";

                    int price = jdbcTemplate.queryForObject("select price from book where isbn = ?", Integer.class, isbn);

                    int stock = jdbcTemplate.queryForObject("select stock from book_stock where isbn = ?", Integer.class, isbn);
                    if (stock == 0) {
                        throw new RuntimeException("库存不足！");
                    }
                    jdbcTemplate.update("update book_stock set stock = stock-1 where isbn = ?", isbn);

                    int balance = jdbcTemplate.queryForObject("select balance from account where username = ?", Integer.class, username);
                    if (balance < price) {
                        throw new RuntimeException("余额不足！");
                    }

                    jdbcTemplate.update("update account set balance = balance - ? where username = ?", price, username);

                    i = 1;
                    System.out.println("success ");
                } catch (Exception e) {
                    e.printStackTrace();
                    i = 0;
                    System.out.println("fail ");
                    txStatus.setRollbackOnly();// 回滚事务
                    // throw new RuntimeException(e);// 回滚事务
                }
                return new Integer(i);
            }
        });

        System.out.println(obj);
    }
}