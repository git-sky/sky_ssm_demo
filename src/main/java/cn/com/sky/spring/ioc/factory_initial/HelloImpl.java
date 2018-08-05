package cn.com.sky.spring.ioc.factory_initial;


public class HelloImpl implements HelloApi {

	private String message;

	public HelloImpl() {
		this.message = "Hello World!";
	}

	public HelloImpl(String message) {
		this.message = message;
	}

	@Override
	public void sayHello() {
		System.out.println(message);
	}
}
