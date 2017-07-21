package cn.com.sky.spring.ioc.inject.constructor;

public class Hobby {

	private String desc;

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return desc;
	}
}