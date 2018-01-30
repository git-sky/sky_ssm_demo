package cn.com.sky.spring.transaction.propagation.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

	@Autowired
	private BookShopDao bookShopDao;

	public void purchase(String username, String isbn) {

		// 1. 获取书的单价
		int price = bookShopDao.findBookPriceIsdn(isbn);

		// 2. 更新书的库存
		bookShopDao.updateBookStock(isbn);

		try {
			// 3. 更新用户余额
			bookShopDao.updateUserAccount(username, 100);
		} catch (Exception e) {// catch之后就不会回滚了
			e.printStackTrace();
		}

//		JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");
//
//		Jedis jedis = pool.getResource();
//
//		// 添加数据
//		jedis.hset("hashs", "entryKey", "entryValue");
//		System.out.println(jedis.hget("hashs", "entryKey"));

//		 throw new RuntimeException("我就要回滚");// 随便抛出RuntimeException异常，都会导致方法的回滚。
	}

}