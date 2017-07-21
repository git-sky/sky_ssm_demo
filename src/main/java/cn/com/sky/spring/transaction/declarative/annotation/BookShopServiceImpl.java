package cn.com.sky.spring.transaction.declarative.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

	@Autowired
	private BookShopDao bookShopDao;

	// 添加事务注解
	// 默认REQUIRED
	// 1. REQUIRES_NEW:使用自己的事务，调用该事物方法的事务被挂起
	// 2. 用propagation指定事务的隔离级别，最常用的是READ_COMMITTED
	// 3. 使用readOnly指定事务是否为只读，表示这个事务只读取数据，不更新数据，这样可以帮助数据库引擎优化事务。
	// 如果真的是一个只读取数据库值的方法，应该设置readOnly=true
	// 4. 使用timeout设置一个时间限额，单位为秒，如果事务的执行时间超过这个时间阈值，事务将被强制回滚。
	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED, readOnly = false, timeout = 5)
//	@Transactional(propagation = Propagation.REQUIRED)
	// @Transactional //默认是REQUIRED
	public void purchase(String username, String isbn) {
		// 1. 获取书的单价
		int price = bookShopDao.findBookPriceIsdn(isbn);

		// 2. 更新书的库存
		bookShopDao.updateBookStock(isbn);

		// 3. 更新用户余额
		bookShopDao.updateUserAccount(username, price);
	}

}