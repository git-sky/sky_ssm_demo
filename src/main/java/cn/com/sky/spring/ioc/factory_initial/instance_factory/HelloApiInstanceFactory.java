package cn.com.sky.spring.ioc.factory_initial.instance_factory;

import cn.com.sky.spring.ioc.factory_initial.HelloApi;
import cn.com.sky.spring.ioc.factory_initial.HelloImpl;

public class HelloApiInstanceFactory {
	
	public HelloApi newInstance(String message) {
		return new HelloImpl(message);
	}
	
}
