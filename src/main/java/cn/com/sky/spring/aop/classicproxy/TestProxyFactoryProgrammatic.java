package cn.com.sky.spring.aop.classicproxy;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;

import cn.com.sky.spring.aop.classicproxy.advice.MyAdvice;
import cn.com.sky.spring.aop.classicproxy.advisor.MyDefaultPointcutAdvisor;
import cn.com.sky.spring.aop.classicproxy.dao.UserDao;
import cn.com.sky.spring.aop.classicproxy.dao.impl.UserDaoImpl;
import cn.com.sky.spring.aop.classicproxy.pointcut.MyStaticMethodMatcherPointcut;

/**
 * 1、手工编程模式织入【织入器ProxyFactory】
 */
public class TestProxyFactoryProgrammatic {

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
        UserDaoImpl target = new UserDaoImpl();

        // 织入器
        ProxyFactory weaver = new ProxyFactory(target);
//        weaver.addAdvisor(advisor);
        weaver.setProxyTargetClass(true);//设置为基于类的代理，默认cglib。
        // weaver.setOptimize(true);//设置为基于类的代理，默认cglib。
        weaver.addAdvice(advice);

        System.out.println("=====================================");


        // 代理对象
        UserDao proxyObject = (UserDao) weaver.getProxy();
        proxyObject.query();

        System.out.println("+++++++++++++++++++++++++++++++++++++++++");

        // 代理对象[基于接口的代理，会报错。基于类的代理，正常。]
        UserDaoImpl proxyObject2 = (UserDaoImpl) weaver.getProxy();
        proxyObject2.query();

        System.out.println("proxy class= " + proxyObject.getClass());

//		ProxyFactoryBean pfb = new ProxyFactoryBean();
//		pfb.getObject();
    }

}
