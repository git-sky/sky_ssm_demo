package cn.com.sky.spring.transaction.programmatic.template;

public interface BookShopDao {
	// 根据书号获取书的单价
	public int findBookPriceIsdn(String isbn);

	// 更新书的库存，使得书号对应的库存-1
	public void updateBookStock(String isbn);

	// 更新用户的账户余额：使得相应username记录的balance-price
	public void updateUserAccount(String username, int price);
}