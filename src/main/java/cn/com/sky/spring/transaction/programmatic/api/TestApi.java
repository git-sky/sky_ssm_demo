package cn.com.sky.spring.transaction.programmatic.api;

import java.beans.PropertyVetoException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestApi {

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

		JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
		DataSourceTransactionManager txManager = new DataSourceTransactionManager(datasource);

		DefaultTransactionDefinition txDefinition = new DefaultTransactionDefinition();// 事务定义类
		txDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

		TransactionStatus txStatus = txManager.getTransaction(txDefinition);// 返回事务对象

		try {
			String username = "Lucy";
			String isbn = "1001";

			// 1. 获取书的单价
			int price = jdbcTemplate.queryForObject("select price from book where isbn = ?", Integer.class, isbn);

			// 2. 更新书的库存
			int stock = jdbcTemplate.queryForObject("select stock from book_stock where isbn = ?", Integer.class, isbn);
			if (stock == 0) {
				throw new RuntimeException("库存不足！");
			}
			jdbcTemplate.update("update book_stock set stock = stock-1 where isbn = ?", isbn);

			// 3. 更新用户余额
			int balance = jdbcTemplate.queryForObject("select balance from account where username = ?", Integer.class, username);
			if (balance < price) {
				throw new RuntimeException("余额不足！");
			}
			jdbcTemplate.update("update account set balance = balance - ? where username = ?", price, username);

			txManager.commit(txStatus);
			System.out.println("purchase success!");

		} catch (Exception e) {
			txManager.rollback(txStatus);
			e.printStackTrace();
			System.out.println("purchase error!");
		}

	}

}
