package cn.com.sky.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;

/**
 * <pre>
 * 
 * 两种方式指定Aspect执行顺序：
 * a. 实现org.springframework.core.Ordered接口，实现它的getOrder()方法.
 * b. 给aspect添加@Order注解，该注解全称为：org.springframework.core.annotation.Order.
 * 
 */
@Aspect
public class MyAdvice5 implements Ordered {

	@Pointcut("execution(* cn.com.sky.spring.aop.annotation.*.query(..))")
	private void my() {// private只能在当前Aspect中使用，public可以在所有Aspect中使用。返回类型必须是void类型。
	}

	@Before("my()")
	public void before(JoinPoint point) throws Throwable {
		System.out.println(this.getClass().getName() + " before: " + point.getTarget().getClass().getName() + "." + point.getSignature().getName());
	}

	@Before("my()")
	public void before2(JoinPoint point) throws Throwable {
		System.out.println(this.getClass().getName() + " before2: " + point.getTarget().getClass().getName() + "." + point.getSignature().getName());
	}

	@Before("my()")
	public void before3(JoinPoint point) throws Throwable {
		System.out.println(this.getClass().getName() + " before3: " + point.getTarget().getClass().getName() + "." + point.getSignature().getName());
	}

	@AfterReturning("my()")
	public void afterReturning(JoinPoint point) throws Throwable {
		System.out.println(this.getClass().getName() + " afterReturning: " + point.getTarget().getClass().getName() + "." + point.getSignature().getName());
	}

	@AfterReturning("my()")
	public void afterReturning2(JoinPoint point) throws Throwable {
		System.out.println(this.getClass().getName() + " afterReturning2: " + point.getTarget().getClass().getName() + "." + point.getSignature().getName());
	}

	@AfterReturning("my()")
	public void afterReturning3(JoinPoint point) throws Throwable {
		System.out.println(this.getClass().getName() + " afterReturning3: " + point.getTarget().getClass().getName() + "." + point.getSignature().getName());
	}

	@After("my()")
	public void after(JoinPoint point) throws Throwable {
		System.out.println(this.getClass().getName() + " after: " + point.getTarget().getClass().getName() + "." + point.getSignature().getName());
	}

	@After("my()")
	public void after2(JoinPoint point) throws Throwable {
		System.out.println(this.getClass().getName() + " after2: " + point.getTarget().getClass().getName() + "." + point.getSignature().getName());
	}

	@After("my()")
	public void after3(JoinPoint point) throws Throwable {
		System.out.println(this.getClass().getName() + " after3: " + point.getTarget().getClass().getName() + "." + point.getSignature().getName());
	}

	@Override
	public int getOrder() {
		return 1;
	}

}
