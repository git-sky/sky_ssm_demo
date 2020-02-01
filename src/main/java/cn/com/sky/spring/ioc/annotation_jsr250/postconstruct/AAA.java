package cn.com.sky.spring.ioc.annotation_jsr250.postconstruct;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * <pre>
 *
 *  @PostConstruct 注解好多人以为是Spring提供的。其实是Java自己的注解。
 *
 * Java中该注解的说明：@PostConstruct该注解被用来修饰一个非静态的void() 方法。
 * 被@PostConstruct 修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器执行一次。
 * PostConstruct 在构造函数之后执行，init()方法之前执行。
 *
 * 通常我们会是在Spring框架中使用到 @PostConstruct注解。
 * 该注解的方法在整个Bean初始化中的执行顺序：
 *
 * Constructor(构造方法) -> @Autowired(依赖注入) -> @PostConstruct(注释的方法)
 *
 *
 * 执行顺序： Constructor >> @Autowired >> @PostConstruct
 *
 *  </pre>
 */
public class AAA {

    @Autowired
    private BBB b;

    public AAA() {
        System.out.println("此时b还未被注入: b = " + b);
    }

    @PostConstruct
    private void init() {
        System.out.println("@PostConstruct 将在依赖注入完成后被自动调用: b = " + b);
    }

    public void send(Integer integer) {
        System.out.println(integer);
    }


    @PreDestroy
    private void destroy() {
        System.out.println("@PreDestroy ....");
    }
}
