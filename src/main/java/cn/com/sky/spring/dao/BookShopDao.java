package cn.com.sky.spring.dao;

public interface BookShopDao {
    // 根据书号获取书的单价
    int findBookPriceIsdn(String isbn);

    // 更新书的库存，使得书号对应的库存-1
    void updateBookStock(String isbn);

    // 更新用户的账户余额：使得相应username记录的balance-price
    void updateUserAccount(String username, int price);
}