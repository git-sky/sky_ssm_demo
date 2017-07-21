package cn.com.sky.spring.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class BookShopDaoImpl implements BookShopDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

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
		}

		String sql = "update account set balance = balance - ? where username = ?";
		jdbcTemplate.update(sql, price, username);
	}

}