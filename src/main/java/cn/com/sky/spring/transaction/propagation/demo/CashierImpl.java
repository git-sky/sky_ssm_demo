package cn.com.sky.spring.transaction.propagation.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cashier")
public class CashierImpl implements ICashier {

    @Autowired
    private BookShopService bookShopService;

    @Override
    public void checkout(String username, List<String> isbns) {
        for (String isbn : isbns) {
            bookShopService.purchase(username, isbn);
        }
    }

}