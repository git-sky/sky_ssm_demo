package cn.com.sky.spring.transaction.declarative.proxy;

import java.util.List;

public interface Cashier {
	public void checkout(String username, List<String> isbns);

}