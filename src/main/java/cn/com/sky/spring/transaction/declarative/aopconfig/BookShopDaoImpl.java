package cn.com.sky.spring.transaction.declarative.aopconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
//	public int findNotExistsSql(String isbn) {
//		String sql = "select price from abc where isbn = ?";
//		return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
//	}

	public int findBookPriceIsdn(String isbn) {
		String sql = "select price from book where isbn = ?";
		return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
	}

	public void updateBookStock(String isbn) {
		String sql0 = "select stock from book_stock where isbn = ?";
		int stock = jdbcTemplate.queryForObject(sql0, Integer.class, isbn);
		if (stock == 0) {
			throw new RuntimeException("库存不足！");
		}
		String sql = "update book_stock set stock = stock-1 where isbn = ?";
		jdbcTemplate.update(sql, isbn);
	}

	public void updateUserAccount(String username, int price) {
		String sql0 = "select balance from account where username = ?";
		int balance = jdbcTemplate.queryForObject(sql0, Integer.class, username);
		if (balance < price) {
			throw new RuntimeException("余额不足！");
			// throw new
			// Exception("余额不足！");
			// 事务不会回滚,只有设置
			// @Transaction(RollbackFor=Exception.class)或者
			// rollback-for="Exception"才会回滚。
		}

		String sql = "update account set balance = balance - ? where username = ?";
		jdbcTemplate.update(sql, price, username);
	}

}