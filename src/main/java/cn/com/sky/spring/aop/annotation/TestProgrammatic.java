package cn.com.sky.spring.aop.annotation;

import org.junit.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * <pre>
 *
 * 基于@AspectJ注解的AOP（注解AOP实现）
 *
 * 1、手工编程实现织入【织入器 AspectJProxyFactory】
 *
 * </pre>
 */
public class TestProgrammatic {

    public static void main(String[] args) {
        AspectJProxyFactory weaver = new AspectJProxyFactory();
        weaver.setProxyTargetClass(true);
        weaver.setTarget(new UserDaoImpl());
        weaver.addAspect(MyAspect.class);
        UserDao userDao = weaver.getProxy();
        userDao.add();
        userDao.delete();
        userDao.update();
        userDao.query();

        // 面向AspectJ的Pointcut实现
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* cn.com.sky.spring.aop.annotation.*.*(..)");
        System.out.println(pointcut.getExpression());

    }

    @Test
    public void testorder() {

        // 编程方式的 Aspect 执行顺序由 addAspect() 顺序决定。
        AspectJProxyFactory weaver = new AspectJProxyFactory();
        weaver.setProxyTargetClass(true);
        weaver.setTarget(new UserDaoImpl());
        weaver.addAspect(MyAspect5.class);
        weaver.addAspect(MyAspect4.class);
        weaver.addAspect(MyAspect3.class);
        UserDao userDao = weaver.getProxy();
        userDao.query();
    }
}
