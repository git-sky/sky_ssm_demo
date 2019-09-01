package cn.com.sky.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

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
@Order(3)
@Aspect
public class MyAspect3 {

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

}
