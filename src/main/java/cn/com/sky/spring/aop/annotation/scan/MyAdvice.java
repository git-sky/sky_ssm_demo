package cn.com.sky.spring.aop.annotation.scan;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class MyAdvice {

	@Pointcut("execution(* cn.com.sky.spring.aop.annotation.scan.*..*(..))")
	private void my() {
	}

	// 在调用方法之前执行 执行拦截包cn.com.sky.spring.aop.demo3.annotation.*下所有的方法
	@Before("my()")
	// @Before("execution(* cn.com.sky.spring.aop.annotation.*..*(..))")
	public void before(JoinPoint point) throws Throwable {
		System.out.println("before: " + point.getTarget().getClass().getName() + "." + point.getSignature().getName());
	}

	// 在调用方法前后执行
	@Around("my()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		System.out.println("around: " + point.getTarget().getClass().getName() + "." + point.getSignature().getName());
		if (point.getArgs().length > 0) {
			return point.proceed(point.getArgs());
		} else {
			return point.proceed();
		}
	}

	// 在调用方法之后执行
	@After("my()")
	public void afterReturning(JoinPoint point) throws Throwable {
		System.out.println("afterReturning: " + point.getTarget().getClass().getName() + "." + point.getSignature().getName());
	}

	// 当抛出异常时被调用
	@AfterThrowing(value = "my()", throwing = "ex")
	public void doThrowing(JoinPoint point, Throwable ex) {
		System.out.println("doThrowing: " + point.getTarget().getClass().getName() + "." + point.getSignature().getName() + " throw exception");
		System.out.println(ex.getMessage());
	}

}
