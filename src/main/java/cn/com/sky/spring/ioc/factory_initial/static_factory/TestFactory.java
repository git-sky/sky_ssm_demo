package cn.com.sky.spring.ioc.factory_initial.static_factory;

import cn.com.sky.spring.ioc.factory_initial.HelloApi;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * <pre>
 *
 *  静态工厂方式实例化Bean
 *
 * </pre>
 */
public class TestFactory {

    private static String getPath() {
        String path = TestFactory.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        System.out.println(p);
        return p;
    }

    @Test
    public void testInstantiatingBeanByStaticFactory() {

        String configLocation = getPath() + "/initial.xml";
        // 使用静态工厂方法
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(configLocation);
        HelloApi bean3 = beanFactory.getBean("bean3", HelloApi.class);
        bean3.sayHello();
        System.out.println(bean3);
    }

    @Test
    public void testBeanFactory() {
        String configLocation = getPath() + "/initial.xml";

//        Resource resource = new ClassPathResource(configLocation);
//        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
//        reader.loadBeanDefinitions(resource);
//        factory.addBeanPostProcessor(new MyBeanPostProcessor());

        ConfigurableBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(configLocation));

        HelloApi bean3 = beanFactory.getBean("bean3", HelloApi.class);
        bean3.sayHello();
        System.out.println(bean3);
    }
}