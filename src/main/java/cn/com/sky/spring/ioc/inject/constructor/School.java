package cn.com.sky.spring.ioc.inject.constructor;

public class School {

	private String name;
	private String location;

	public School(String name, String location) {
		this.name = name;
		this.location = location;
	}

	@Override
	public String toString() {
		return "School [name=" + name + ", location=" + location + "]";
	}
}