package cn.com.sky.spring.aop.classicproxy.pointcut;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

/**
 * <pre>
 * 自定义静态切点StaticMethodMatcherPointcut，
 * 只需要实现boolean matches(Method method, Class<?> targetClass)方法。
 */
public class MyStaticMethodMatcherPointcut extends StaticMethodMatcherPointcut {

	private List<String> methods = new LinkedList<String>();

	public void setMethods(String... methods) {
		this.methods = new LinkedList<String>();
		if (methods != null) {
			this.methods.addAll(Arrays.asList(methods));
		}
	}

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		for (String name : this.methods) {
			if (name.equals(method.getName())) {
				return true;
			}
		}
		return false;
	}

}
