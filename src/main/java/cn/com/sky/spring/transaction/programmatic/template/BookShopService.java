package cn.com.sky.spring.transaction.programmatic.template;

public interface BookShopService {

    void purchase(String username, String isbn);

    void purchase2(String username, String isbn);

}