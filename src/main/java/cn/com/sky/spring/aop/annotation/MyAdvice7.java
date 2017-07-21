package cn.com.sky.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * <pre>
 * 
 * 不同的Aspect是按照定义的@Order或者getOrder()的大小顺序执行的（从小到大）。 
 * 相同类型的Advice通知是按照定义的顺序来执行的（从上到下）。
 * 不同类型Advice通知的执行顺序：
 * 1> @Around 1
 * 2> @Before
 * 3> method 执行
 * 4> @Around 2
 * 5> @After
 * 6> @AfterReturning / @AfterThrowing
 * 
 * <pre>
 */
@Aspect
public class MyAdvice7 {

	@Pointcut("execution(* cn.com.sky.spring.aop.annotation.*.query(..))")
	private void myquery() {// private只能在当前Aspect中使用，public可以在所有Aspect中使用。返回类型必须是void类型。
	}

	@Pointcut("execution(* cn.com.sky.spring.aop.annotation.*.test(..))")
	private void mytest() {// private只能在当前Aspect中使用，public可以在所有Aspect中使用。返回类型必须是void类型。
	}

	@Pointcut("myquery()||mytest()")
	private void my() {// private只能在当前Aspect中使用，public可以在所有Aspect中使用。返回类型必须是void类型。
	}

	@Before("my()")
	public void before(JoinPoint point) throws Throwable {
		System.out.println(this.getClass().getName() + " before: " + point.getTarget().getClass().getName() + "." + point.getSignature().getName());
	}

	@After("my()")
	public void after(JoinPoint point) throws Throwable {
		System.out.println(this.getClass().getName() + " after: " + point.getTarget().getClass().getName() + "." + point.getSignature().getName());
	}

	@AfterReturning("my()")
	public void afterReturning(JoinPoint point) throws Throwable {
		System.out.println(this.getClass().getName() + " afterReturning: " + point.getTarget().getClass().getName() + "." + point.getSignature().getName());
	}

	@AfterThrowing(value = "my()", throwing = "ex")
	public void afterThrowing(JoinPoint point, Throwable ex) {
		System.out.println(this.getClass().getName() + " afterThrowing: " + point.getTarget().getClass().getName() + "." + point.getSignature().getName() + " throw exception");
		System.out.println(ex.getMessage());
	}

	@Around("my()")
	public void around(ProceedingJoinPoint point) throws Throwable {
		System.out.println(this.getClass().getName() + " around before: " + point.getTarget().getClass().getName() + "." + point.getSignature().getName());
		if (point.getArgs().length > 0) {
			point.proceed(point.getArgs());
		} else {
			point.proceed();
		}
		System.out.println(this.getClass().getName() + " around after: " + point.getTarget().getClass().getName() + "." + point.getSignature().getName());
	}

}
