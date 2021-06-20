package cn.com.sky.spring.ioc.bean_lifecycle.aware;

import cn.com.sky.spring.ioc.bean_lifecycle.MyBeanPostProcessor;
import org.junit.Test;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * <pre>
 *
 * 测试Bean的生命周期-aware
 * </pre>
 */
public class TestBeanLife {

    private String getPath() {
        String path = TestBeanLife.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        return p;
    }

    @Test
    public void testApplicationContext() {

        String configLocation = getPath() + "/aware.xml";

        // 1.容器初始化
        System.out.println("=================1.容器初始化===================");
        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);

        // 2. 从IOC容器中获取Bean实例
        System.out.println("==================2.从IOC容器中获取Bean实例==================");
        Student student = (Student) context.getBean("sky");

        // 3.调用方法
        System.out.println("==================3.调用方法==================");
        System.out.println(student);
        student.say();

        // 4.关闭容器
        System.out.println("==================4.关闭容器==================");
        //加上这个，才会执行销毁方法（DisposableBean -> destroy() 和 destroy-method ）
        ((ClassPathXmlApplicationContext) context).registerShutdownHook();

    }

    @Test
    public void testBeanFactory() {
        String configLocation = getPath() + "/aware.xml";

//        Resource resource = new ClassPathResource(configLocation);
//        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
//        reader.loadBeanDefinitions(resource);
//        factory.addBeanPostProcessor(new MyBeanPostProcessor());


        ConfigurableBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(configLocation));

        beanFactory.addBeanPostProcessor(new MyBeanPostProcessor());
        // beanFactory.getBean("sky");
//        for (int i = 0; i <= 3; i++) {
//            Teacher teacher = (Teacher) beanFactory.getBean("teacher");
//            System.out.println(teacher);
//        }

        for (int i = 0; i < 10; i++) {
            Student student = (Student) beanFactory.getBean("sky");
            System.out.println(student);
            student.say();
        }

        //加上这个，才会执行销毁方法（DisposableBean -> destroy() 和 destroy-method ）
        beanFactory.destroySingletons();
    }
}