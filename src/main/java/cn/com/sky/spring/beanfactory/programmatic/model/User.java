package cn.com.sky.spring.beanfactory.programmatic.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {

	private String name;

	@Autowired
	private Account account;
	private Address addr;

	public User() {
		super();
	}

	public User(Account account, Address addr) {
		super();
		this.account = account;
		this.addr = addr;
	}

	public User(Account account) {
		super();
		this.account = account;
	}

	public User(String name, Account account) {
		super();
		this.name = name;
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	public void say() {
		System.out.println("saying..." + account + "," + addr);
	}

}
