package cn.com.sky.spring.transaction.programmatic.template;

public interface BookShopService {

	public void purchase(String username, String isbn);

	public void purchase2(String username, String isbn);

}