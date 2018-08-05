package cn.com.sky.spring.ioc.factory_initial.static_factory;

import cn.com.sky.spring.ioc.factory_initial.HelloApi;
import cn.com.sky.spring.ioc.factory_initial.HelloImpl;

public class HelloApiStaticFactory {
	// 工厂方法
	public static HelloApi newInstance(String message) {
		// 返回需要的Bean实例
		return new HelloImpl(message);
	}
}