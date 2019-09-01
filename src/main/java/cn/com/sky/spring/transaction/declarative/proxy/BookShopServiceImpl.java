package cn.com.sky.spring.transaction.declarative.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bookShopServiceTarget")
public class BookShopServiceImpl implements BookShopService {

    @Autowired
    private BookShopDao bookShopDao;

    @Override
    public void purchase(String username, String isbn) {
        // 1. 获取书的单价
        int price = bookShopDao.findBookPriceIsdn(isbn);

        // 2. 更新书的库存
        bookShopDao.updateBookStock(isbn);

        // 3. 更新用户余额
        bookShopDao.updateUserAccount(username, price);
    }

}