package cn.com.sky.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * <pre>
 *
 * Spring AOP支持的AspectJ切入点指示符
 *
 * 切入点指示符用来指示切入点表达式目的，在Spring AOP中目前只有执行方法这一个连接点，Spring AOP支持的AspectJ切入点指示符如下：
 *
 *  execution：用于匹配方法执行的连接点；
 *
 *  within：用于匹配指定类型内的方法执行；
 *
 *  this：用于匹配当前AOP代理对象类型的执行方法；注意是AOP代理对象的类型匹配，这样就可能包括引入接口也类型匹配；
 *
 *  target：用于匹配当前目标对象类型的执行方法；注意是目标对象的类型匹配，这样就不包括引入接口也类型匹配；
 *
 *  args：用于匹配当前执行的方法传入的参数为指定类型的执行方法；
 *
 *  @within：用于匹配所以持有指定注解类型内的方法；
 *
 *  @target：用于匹配当前目标对象类型的执行方法，其中目标对象持有指定的注解；
 *
 *  @args：用于匹配当前执行的方法传入的参数持有指定注解的执行；
 *
 *  @annotation：用于匹配当前执行方法持有指定注解的方法；
 *
 *  bean：Spring AOP扩展的，AspectJ没有对于指示符，用于匹配特定名称的Bean对象的执行方法；
 *
 *  reference pointcut：表示引用其他命名切入点，只有@ApectJ风格支持，Schema风格不支持。
 *
 *
 * AspectJ切入点支持的切入点指示符还有： call、get、set、preinitialization、staticinitialization、initialization、handler、adviceexecution、withincode、cflow、cflowbelow、if、@this、@withincode；
 * 但Spring AOP目前不支持这些指示符，使用这些指示符将抛出IllegalArgumentException异常。这些指示符Spring AOP可能会在以后进行扩展。
 */
@Aspect
public class MyAspect2 {

    // 引用其他Aspect的Pointcut
    @Pointcut("cn.com.sky.spring.aop.annotation.MyAspect.my2()")
    private void my() {
    }

    @Pointcut("execution(* cn.com.sky.spring.aop.annotation.*.query(..))")
    private void my4() {
    }

    // 在annotation包中的任意连接点（在Spring AOP中只是方法执行）：
    @Pointcut("within(cn.com.sky.spring.aop.annotation.*)")
    private void my2() {
    }

    // 在annotation包或其子包中的任意连接点（在Spring AOP中只是方法执行）：
    @Pointcut("within(cn.com.sky.spring.aop.annotation..*)")
    private void my3() {
    }

    @Before("my2()")
    public void before(JoinPoint point) throws Throwable {
        System.out.println(this.getClass().getName() + "--- before: " + point.getTarget().getClass().getName() + "." + point.getSignature().getName());
    }

}
