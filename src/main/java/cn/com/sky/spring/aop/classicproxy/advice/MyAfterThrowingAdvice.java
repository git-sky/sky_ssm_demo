package cn.com.sky.spring.aop.classicproxy.advice;

import java.lang.reflect.Method;

public class MyAfterThrowingAdvice implements MyThrowsAdvice {

	@Override
	public void afterThrowing(Throwable t) {
		System.out.println("====afterThrowing(Throwable t)====");

	}

	@Override
	public void afterThrowing(RuntimeException e) {
		System.out.println("====afterThrowing(RuntimeException e)====");

	}

	@Override
	public void afterThrowing(Method m, Object[] args, Object target, Exception e) {
		System.out.println("====afterThrowing(Method m, Object[] args, Object target, Exception e)====");

	}

}
