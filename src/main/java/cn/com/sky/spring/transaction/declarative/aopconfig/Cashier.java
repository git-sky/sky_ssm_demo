package cn.com.sky.spring.transaction.declarative.aopconfig;

import java.util.List;

public interface Cashier {
	public void checkout(String username, List<String> isbns);

}