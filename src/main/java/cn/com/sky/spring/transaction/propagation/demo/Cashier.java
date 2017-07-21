package cn.com.sky.spring.transaction.propagation.demo;

import java.util.List;

public interface Cashier {
	public void checkout(String username, List<String> isbns);

}