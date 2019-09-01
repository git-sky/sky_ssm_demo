package cn.com.sky.spring.aop.classicproxy.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * <pre>
 *
 * 在Spring中，Advice按照其自身实例（instance）能否在目标对象类的所有实例中共享这一标准，
 * 可以划分为两大类，即per-class类型的Advice和per-instance类型的Advice。
 *
 * per-class类型的Advice是指，该类型的Advice的实例可以在目标对象类的所有实例之间共享。
 * 这种类型的Advice通常只是提供方法拦截的功能，不会为目标对象类保存任何状态或者添加新的特性。它也是我们最常见的Advice。
 *
 *
 * 实现通知接口,横切逻辑
 */
public class MyAdvice extends MyAroundAdvice implements MethodBeforeAdvice, AfterReturningAdvice, MyThrowsAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("====after returning====");
    }

    @Override
    public void afterThrowing(Throwable t) {
        System.out.println("====afterThrowing(Throwable t)====");

    }

    @Override
    public void afterThrowing(RuntimeException e) {
        System.out.println("====afterThrowing(RuntimeException e)====");

    }

    @Override
    public void afterThrowing(Method m, Object[] args, Object target, Exception e) {
        System.out.println("====afterThrowing(Method m, Object[] args, Object target, Exception e)====");

    }

    //实现的MethodBeforeAdvice
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("====before advice====");
    }
}
