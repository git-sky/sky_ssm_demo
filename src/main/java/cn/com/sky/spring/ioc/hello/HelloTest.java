package cn.com.sky.spring.ioc.hello;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring的bean默认是单例的，单例的bean默认是立即加载。
 * <p>
 * Spring提供“singleton”和“prototype”两种基本作用域，另外提供“request”、“session”、“global
 * session”三种web作用域；Spring还允许用户定制自己的作用域。
 */
public class HelloTest {
    @Test
    public void testHelloWorld() {
        // 1、读取配置文件实例化一个IoC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("cn/com/sky/spring/ioc/hello/hello.xml");
        // 2、从容器中获取Bean，注意此处完全“面向接口编程，而不是面向实现”
        HelloApi helloApi = context.getBean("hello", HelloApi.class);
        // // 3、执行业务逻辑
        helloApi.sayHello();
        //
        // //根据name获取bean
        HelloApi helloName = context.getBean("helloName", HelloApi.class);
        helloName.sayHello();
        //
        // //根据别名获取bean
        HelloApi alias1 = context.getBean("alias1", HelloApi.class);
        alias1.sayHello();
    }
}