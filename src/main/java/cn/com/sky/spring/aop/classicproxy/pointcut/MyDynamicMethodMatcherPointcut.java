package cn.com.sky.spring.aop.classicproxy.pointcut;

import java.lang.reflect.Method;

import org.springframework.aop.support.DynamicMethodMatcherPointcut;

/**
 * <pre>
 * 
 * 自定义动态切点DynamicMethodMatcherPointcut，
 * 只需要实现boolean matches(Method method, Class<?> targetClass, Object[] args)方法。
 */
public class MyDynamicMethodMatcherPointcut extends DynamicMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> targetClass, Object[] args) {
		return false;
	}

}
