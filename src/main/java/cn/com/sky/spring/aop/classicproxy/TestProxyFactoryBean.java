package cn.com.sky.spring.aop.classicproxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.sky.spring.aop.classicproxy.dao.UserDao;

/**
 * <pre>
 * try {
 * 	// 执行前置通知；before advice
 *
 * 	// 执行目标方法；
 *
 * 	// 执行返回通知；after returning advice
 * } catch (Exception e) {
 * 	// 执行异常通知； after throwing advice
 * } finally {
 * 	// 执行后置通知；after advice
 * }
 *
 * ProxyFactoryBean（Proxy+FactoryBean ） --基于容器配置的织入器
 *
 * 1. 代理模式
 */
public class TestProxyFactoryBean {

    private static String getPath() {
        String path = TestProxyFactoryBean.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        System.out.println(p);
        return p;
    }

    public static void main(String[] args) {

        String configLocation = getPath() + "/aop_proxy.xml";// 基本代理模式

        final ApplicationContext appCtx = new ClassPathXmlApplicationContext(configLocation);
        UserDao userDao = (UserDao) appCtx.getBean("userDao");
        userDao.add();
        userDao.delete();
        userDao.update();
        userDao.query();


        try {
            userDao.test();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}