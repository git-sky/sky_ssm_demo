package cn.com.sky.spring.aop.classicproxy;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;

import cn.com.sky.spring.aop.classicproxy.dao.UserDao;
import cn.com.sky.spring.aop.classicproxy.dao.impl.UserDaoImpl;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;

/**
 * 对于： proxyFactory.addAdvice()，ProxyFactory将为这些Advice构造相应的Advisor，只不过是匹配所有的Joinpoint.
 * <p>
 * ProxyFactory编程实现。
 */
public class TestProxyFactoryProgrammatic2 {

    public static void main(String[] args) {
        // 代理对象需要的实现的接口
        Class[] interfaces = new Class[]{UserDao.class};
        // 利用spring的API,创建代理工厂
        ProxyFactory proxyFactory = new ProxyFactory(interfaces);
        // 设置目标对象
        proxyFactory.setTarget(new UserDaoImpl());
        // proxyFactory.setInterfaces(interfaces);

        /**
         * Set whether proxies created by this configuration should be prevented from being cast to
         * Advised to query proxy status. Default is "false", meaning that any AOP proxy can be cast
         * to Advised.
         * */
        // proxyFactory.setOpaque(true);

        // 添加方法通知/增强
        proxyFactory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("1111111111在方法调用之前拦截");
            }
        });
        proxyFactory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("22222222在方法调用之前拦截");
            }
        });
        proxyFactory.addAdvice(new AfterReturningAdvice() {
            @Override
            public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
                System.out.println("方法完成之后调用的方法11111");

            }
        });
        proxyFactory.addAdvice(new AfterReturningAdvice() {
            @Override
            public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
                System.out.println("方法完成之后调用的方法22222");

            }
        });

        // 对于环绕通知只能添加一个,多添加也是没有用的，spring会选第一个advice，请看结果
        proxyFactory.addAdvice(new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                System.out.println("1111111环绕通知");
                Object[] params = invocation.getArguments();
                Method method = invocation.getMethod();
                Object target = invocation.getThis();
                Object bytes = method.invoke(target, params);
                byte[] result = (byte[]) bytes;
                System.out.println("1111111111环绕通知生成的结果--" + new String(result));
                return "北京生活圈".getBytes();
            }
        });

        // 对于环绕通知只能添加一个,多添加也是没有用的，spring会选第一个advice，请看结果
        proxyFactory.addAdvice(new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                System.out.println("22222环绕通知");
                Object[] params = invocation.getArguments();
                Method method = invocation.getMethod();
                Object target = invocation.getThis();
                Object bytes = method.invoke(target, params);
                byte[] result = (byte[]) bytes;
                System.out.println("222222环绕通知生成的结果--" + new String(result));
                return bytes;
            }
        });


        Object proxy = proxyFactory.getProxy(proxyFactory.getClass().getClassLoader());

//		Class[] inters = proxy.getClass().getInterfaces();
//		for (Class str : inters) {
//			System.out.println(str.getSimpleName());
//		}

        UserDao userDao = (UserDao) proxy;
//        userDao.query();

        System.out.println(userDao.query("abc"));


        ProxyFactoryBean pfb;

        BeanNameAutoProxyCreator beanNameAutoProxyCreator;
    }
}