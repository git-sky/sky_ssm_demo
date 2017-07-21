package cn.com.sky.spring.ioc.bean_lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * <pre>
 * 
 * 自定义BeanPostProcessor
 * 
 * 第一个参数都是要处理的Bean对象，第二个参数都是Bean的name。返回值也都是要处理的Bean对象。
 * 
 * 
 * 
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

	public MyBeanPostProcessor() {
		System.out.println("constructor MyBeanPostProcessor...");
	}

	// 来自于BeanPostProcessor接口
	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
		System.out.println("postProcessAfterInitialization...[" + arg1 + "],[" + arg0 + "]");
		return arg0;
	}

	// 来自于BeanPostProcessor接口
	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1) throws BeansException {
		System.out.println("postProcessBeforeInitialization...[" + arg1 + "],[" + arg0 + "]");
		return arg0;
	}
}