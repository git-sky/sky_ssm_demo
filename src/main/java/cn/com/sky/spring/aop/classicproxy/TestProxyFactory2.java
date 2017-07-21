package cn.com.sky.spring.aop.classicproxy;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;

import cn.com.sky.spring.aop.classicproxy.advice.MyAdvice;
import cn.com.sky.spring.aop.classicproxy.advisor.MyDefaultPointcutAdvisor;
import cn.com.sky.spring.aop.classicproxy.dao.UserDao;
import cn.com.sky.spring.aop.classicproxy.dao.impl.UserDaoImpl;
import cn.com.sky.spring.aop.classicproxy.pointcut.MyStaticMethodMatcherPointcut;

public class TestProxyFactory2 {

	public static void main(String[] args) {

		// 增强
		MyAdvice advice = new MyAdvice();

		// 切点
		MyStaticMethodMatcherPointcut pointcut = new MyStaticMethodMatcherPointcut();
		pointcut.setMethods("query");

		// 切面
		MyDefaultPointcutAdvisor advisor = new MyDefaultPointcutAdvisor();
		advisor.setAdvice(advice);
		advisor.setPointcut(pointcut);
		advisor.setOrder(1);

		// 被代理对象
		UserDaoImpl ud = new UserDaoImpl();

		// 织入器
		ProxyFactory weaver = new ProxyFactory(ud);
		weaver.addAdvisor(advisor);
		// weaver.setProxyTargetClass(true);//设置为基于类的代理，默认cglib。
		// weaver.setOptimize(true);//设置为基于类的代理，默认cglib。

		// 代理对象
		UserDao proxyObject = (UserDao) weaver.getProxy();
		proxyObject.query();

//		System.out.println(proxyObject.getClass());

//		ProxyFactoryBean pfb = new ProxyFactoryBean();
//		pfb.getObject();
	}

}
