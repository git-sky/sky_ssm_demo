package cn.com.sky.spring.aop.classicproxy.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

/**
 * Around Advice
 */
public class MyAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		StopWatch watch = new StopWatch();
		try {
			watch.start();
			System.out.println("===around before ===");
			Object result = invocation.proceed();
			System.out.println("===around after ===");
			return result;
		} finally {
			watch.stop();
		}
	}

}