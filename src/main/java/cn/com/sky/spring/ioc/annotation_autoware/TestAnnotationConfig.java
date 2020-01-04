package cn.com.sky.spring.ioc.annotation_autoware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.sky.spring.ioc.aggregate.TestCollection;

/**
 * <pre>
 *
 * 使用了@Autowired注解时，Spring就会尝试对该方法执行byType自动装配。
 *
 * <context:annotation-config>有助于完全消除Spring注解中的<property>和<constructor-arg>元素，
 *   但是还是不能完全消除，仍然需要使用<bean>元素显示定义Bean。
 *    @Autowired
 * 	@Qualifier("big")
 *
 *
 *
 * 测试Bean的自动装配-注解实现
 *
 *
 * <context:annotation-config> 不但帮我们把AutowiredAnnotationBeanPostProcessor 和CommonAnnotationBeanPostProcessor注册到容器，
 * 同时还会把 PersistenceAnnotationBeanPostProcessor 和 RequiredAnnotationBeanPostProcessor 一并进行注册，一举四得。
 *
 * </pre>
 */
public class TestAnnotationConfig {

    private static ApplicationContext context;
    private static Student stu;

    private static String getPath() {
        String path = TestAnnotationConfig.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        System.out.println(p);
        return p;
    }

    public static void main(String[] args) {

        String configLocation = getPath() + "/annotation-config.xml";

        context = new ClassPathXmlApplicationContext(configLocation);

        // 2. 从IOC容器中获取Bean实例
        stu = (Student) context.getBean("sky");
        // 3.调用方法
        System.out.println(stu);
        // 4.关闭容器
        ((ClassPathXmlApplicationContext) context).registerShutdownHook();

//		AutowiredAnnotationBeanPostProcessor

    }
}