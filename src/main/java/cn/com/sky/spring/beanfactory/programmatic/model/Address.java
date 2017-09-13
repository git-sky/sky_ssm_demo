package cn.com.sky.spring.beanfactory.programmatic.model;

import org.springframework.stereotype.Component;

@Component
public class Address {

	private String addr;

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Address [addr=" + addr + "]";
	}

}
