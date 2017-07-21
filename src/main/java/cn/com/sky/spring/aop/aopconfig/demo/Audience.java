package cn.com.sky.spring.aop.aopconfig.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * <pre>
 * 
 * try
 * {
 *     //  执行前置通知；
 *      
 *     //  执行目标方法；
 *      
 *     // 执行返回通知；
 * }
 * catche(Exception e)
 * {
 *     // 执行异常通知；
 * }
 * finally
 * {
 *     // 执行后置通知；
 * }
 * 
 * 
 * </pre>
 */
public class Audience {

	public void before(JoinPoint joinPoint) {
		System.out.println("before...." + joinPoint.getSignature().getName());
	}

	public void after_returning() {
		System.out.println("after_returning...");
	}

	public void after_throwing() {
		System.out.println("after_throwing...");
	}

	public void after() {
		System.out.println("after...");
	}

	public void around(ProceedingJoinPoint joinPoint) {
		// 演出之前
		System.out.println("around before...");
		try {
			long start = System.currentTimeMillis();
			// 执行演出操作
			joinPoint.proceed();
			long end = System.currentTimeMillis();
			// 演出成功
			System.out.println("around after_returning...");
		} catch (Throwable e) {
			// 演出失败
			System.out.println("around after_throwing...");
			e.printStackTrace();
		} finally {
			System.out.println("around after...");
		}
	}
}