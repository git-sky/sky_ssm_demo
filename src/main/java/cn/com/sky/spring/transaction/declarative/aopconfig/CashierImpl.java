package cn.com.sky.spring.transaction.declarative.aopconfig;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//cashier--出纳员
@Service("cashier")
public class CashierImpl implements Cashier {

    @Autowired
    private BookShopService bookShopService;

    @Override
    public void checkout(String username, List<String> isbns) {
        for (String isbn : isbns) {
            bookShopService.purchase(username, isbn);
        }
    }

}