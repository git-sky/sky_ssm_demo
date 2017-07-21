package cn.com.sky.spring.aop.classicproxy.advice;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

/**
 * <pre>
 * Spring中以接口定义org.springframework.aop.ThrowsAdvice对应通常AOP概念中的AfterThrowingAdvice。
 * 虽然该接口没有定义任何方法，但是在实现相应的ThrowsAdvice的时候，我们的方法定义需要遵循如下规则：
 * 
 * void afterThrowing([Method, args, target], ThrowableSubclass);
 * 其中，[]中的三个参数可以省略。我们可以根据将要拦截的Throwable的不同类型，在同一个ThrowsAdvice中实现多个afterThrowing方法。
 * 框架将会使用Java反射机制（Java Reflection）来调用这些方法
 */
public interface MyThrowsAdvice extends ThrowsAdvice {

	// 普通异常处理逻辑
	public void afterThrowing(Throwable t);

	// 运行时异常处理逻辑
	public void afterThrowing(RuntimeException e);

	// 处理应用程序生成的异常
	public void afterThrowing(Method m, Object[] args, Object target, Exception e);
}