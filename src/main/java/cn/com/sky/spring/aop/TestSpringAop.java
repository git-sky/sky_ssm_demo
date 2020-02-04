package cn.com.sky.spring.aop;


import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.springframework.aop.*;
import org.springframework.aop.config.AopNamespaceHandler;
import org.springframework.aop.support.*;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.core.Ordered;

public class TestSpringAop {

    @Test
    public void testPointcut() {

        Pointcut pointcut;

        AnnotationMatchingPointcut annotationMatchingPointcut;

        StaticMethodMatcherPointcut staticMethodMatcherPointcut;

        DynamicMethodMatcherPointcut dynamicMethodMatcherPointcut;

        JdkRegexpMethodPointcut jdkRegexpMethodPointcut;

        NameMatchMethodPointcut nameMatchMethodPointcut;

        ComposablePointcut composablePointcut = new ComposablePointcut();
        ComposablePointcut composablePointcut2 = new ComposablePointcut();
        ComposablePointcut un = composablePointcut.union(composablePointcut2);

        Pointcut un2 = Pointcuts.union(composablePointcut, composablePointcut2);

        ControlFlowPointcut controlFlowPointcut;


        ClassFilter classFilter;

        MethodMatcher methodMatcher;

        StaticMethodMatcher staticMethodMatcher;
        StaticMethodMatcherPointcut staticMethodMatcherPointcut1;
        DynamicMethodMatcher dynamicMethodMatcher;

        AopNamespaceHandler aopNamespaceHandler;

    }

    @Test
    public void testAdvice() {

        Advice advice;
        BeforeAdvice beforeAdvice;
        MethodBeforeAdvice methodBeforeAdvice;

        ThrowsAdvice throwsAdvice;

        AfterReturningAdvice afterReturningAdvice;

        AfterAdvice afterAdvice;

        MethodInterceptor methodInterceptor;
    }


    @Test
    public void testAspect() {

// Advisor代表Spring中的Aspect，但是，与正常的Aspect不同，Advisor通常只持有一个Pointcut和一个Advice。
// 而理论上，Aspect定义中可以有多个Pointcut和多个Advice，所以，我们可以认为Advisor是一种特殊的Aspect。
        Advisor advisor;

        PointcutAdvisor pointcutAdvisor;

        DefaultPointcutAdvisor defaultPointcutAdvisor;

        NameMatchMethodPointcutAdvisor nameMatchMethodPointcutAdvisor;

    }

    @Test
    public void testOrdered() {
        Ordered ordered;
        StaticMethodMatcherPointcutAdvisor staticMethodMatcherPointcutAdvisor;
    }
}