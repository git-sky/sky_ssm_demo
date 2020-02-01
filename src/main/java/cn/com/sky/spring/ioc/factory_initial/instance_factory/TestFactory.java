package cn.com.sky.spring.ioc.factory_initial.instance_factory;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import cn.com.sky.spring.ioc.factory_initial.HelloApi;

/**
 * 非静态工厂方法(Instance Factory Method)
 */
public class TestFactory {

    private static String getPath() {
        String path = TestFactory.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        return p;
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testInstantiatingBeanByInstanceFactory() {
        String configLocation = getPath() + "/initial.xml";

//		String configLocation ="/initial.xml";


        // 使用实例工厂方法
//		 BeanFactory beanFactory = new ClassPathXmlApplicationContext(configLocation);

        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(configLocation));
        HelloApi bean4 = beanFactory.getBean("bean4", HelloApi.class);
        bean4.sayHello();
        System.out.println(bean4);
    }
}