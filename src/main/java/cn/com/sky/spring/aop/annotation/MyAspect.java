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
import org.springframework.core.annotation.Order;

/**
 * <pre>
 * 
 * execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern) throws-pattern?)
 * 
 * 必选：
 * 返回类型模式    名字模式(参数模式)
 * ret-type-pattern name-pattern(param-pattern)
 * 
 * 
 * 返回类型模式:
 * *，它代表了匹配任意的返回类型。
 * 
 * 
 * 参数模式：
 * 模式 () 匹配了一个不接受任何参数的方法，
 * 模式 (..) 匹配了一个接受任意数量参数的方法（零或者多个参数）。 
 * 模式 (*) 匹配了一个接受一个任何类型的参数的方法。
 * 模式 (*,String) 匹配了一个接受两个参数的方法，第一个可以是任意类型，第二个则必须是String类型。
 * 
 * 
 * 任意公共方法的执行：
 * execution(public * *(..))
 * 
 * 任何一个名字以“find”开始的方法的执行：
 * execution(* find*(..)) 
 * 
 * 定义在该包(cn.com.sky.aop)里 的任意方法
 * execution(* cn.com.sky.aop.*(..)) 
 * 
 * 定义在该包(cn.com.sky.aop)里的find开头的方法
 * execution(* cn.com.sky.aop.*.find*(..)) 
 * 
 * 定义在该包(cn.com.sky)或者子包(cn.com.sky...)里的find开头的方法
 * execution(* cn.com.sky..*.find*(..))
 * 
 * </pre>
 */

/**
 * 切面的优先级为，有@Order注解的比没有@Order注解的先执行，@Order值小的比大的先执行。
 */
@Order(1)
@Aspect
public class MyAspect {

	@Pointcut("execution(* cn.com.sky.spring.aop.annotation.*.query(..))")
	private void my() {// private只能在当前Aspect中使用，public可以在所有Aspect中使用。返回类型必须是void类型。
	}

	@Pointcut("execution(* cn.com.sky.spring.aop.annotation.*.up*(..))")
	public void my2() {
	}

	// 引用my2()定义的@Pointcut
	@Pointcut("my2()")
	private void my3() {
	}

	// 逻辑运算
	@Pointcut("my2()||my()")
	private void my4() {
	}

	// 获取参数
	@Pointcut("execution(* cn.com.sky.spring.aop.annotation.*.update(..)) && args(taskName)")
	public void my5(String taskName) {
	}

	@Before("my5(taskName)")
	public void beforeWithParam(JoinPoint point, String taskName) throws Throwable {
		System.out.println("beforeWithParam: " + point.getTarget().getClass().getName() + "." + point.getSignature().getName());
		System.out.println("taskName:" + taskName);
	}

	@Before("my()")
	public void before(JoinPoint point) throws Throwable {
		System.out.println("before: " + point.getTarget().getClass().getName() + "." + point.getSignature().getName());

		System.out.println("getArgs:" + point.getArgs());
		System.out.println("getThis:" + point.getThis());
		System.out.println("getTarget:" + point.getTarget());
		System.out.println("getSignature:" + point.getSignature());
	}
	
	@Before("my()")
	public void before2(JoinPoint point) throws Throwable {
		System.out.println("before2: " + point.getTarget().getClass().getName() + "." + point.getSignature().getName());
	}
	

	// 在调用方法前后执行
	@Around("my3()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		System.out.println("around: " + point.getTarget().getClass().getName() + "." + point.getSignature().getName());
		if (point.getArgs().length > 0) {
			return point.proceed(point.getArgs());
		} else {
			return point.proceed();
		}
	}

	// 在调用方法之后执行
	@AfterReturning(pointcut = "my()", returning = "retValue")
	public void afterReturning(JoinPoint point, String retValue) throws Throwable {
		System.out.println("afterReturning: " + point.getTarget().getClass().getName() + "." + point.getSignature().getName());
		System.out.println("retValue:" + retValue);
	}

	// 在调用方法之后执行（finally）
	@After("my()")
	public void after(JoinPoint point) throws Throwable {
		System.out.println("after: " + point.getTarget().getClass().getName() + "." + point.getSignature().getName());
	}

	// 当抛出异常时被调用
	@AfterThrowing(value = "my()", throwing = "ex")
	public void doThrowing(JoinPoint point, Throwable ex) {
		System.out.println("doThrowing: " + point.getTarget().getClass().getName() + "." + point.getSignature().getName() + " throw exception");
		System.out.println(ex.getMessage());
	}

}
