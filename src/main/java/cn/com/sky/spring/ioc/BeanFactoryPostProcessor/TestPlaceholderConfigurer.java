package cn.com.sky.spring.ioc.BeanFactoryPostProcessor;

import org.junit.Test;
import org.springframework.beans.factory.config.PropertyOverrideConfigurer;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class TestPlaceholderConfigurer {

    private String getPath() {
        String path = TestPlaceholderConfigurer.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        return p;
    }

    @Test
    public void test() {

        // 1.beanfactory
        String configLocation = getPath() + "/conf.xml";
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(configLocation));


        // 2.placeholder
        String propFile = getPath() + "/jdbc.properties";
        // 如果要在BeanFactory中使用BeanFactoryPostProcessor 必须手动装配:
        PropertyPlaceholderConfigurer cfg = new PropertyPlaceholderConfigurer();
        cfg.setLocation(new ClassPathResource(propFile));

        // 3.配置
        cfg.postProcessBeanFactory(factory);


        // 配置 PropertyOverrideConfigurer
        String overrideFile = getPath() + "/pool-adjustment.properties";
        // 如果要在BeanFactory中使用BeanFactoryPostProcessor 必须手动装配:
        PropertyOverrideConfigurer overrideConfigurer = new PropertyOverrideConfigurer();
        overrideConfigurer.setLocation(new ClassPathResource(overrideFile));

        overrideConfigurer.postProcessBeanFactory(factory);


        // 4.获取
        DriverManagerDataSource dataSource = (DriverManagerDataSource) factory.getBean("dataSource");

        System.out.println(dataSource.getUrl());
        System.out.println(dataSource.getUsername());
        System.out.println(dataSource.getPassword());


        // 注意，ApplicationContext能够自动辨认和应用在其上部署的实现了BeanFactoryPostProcessor的bean。这就意味着，当使用ApplicationContext的时候应用PropertyPlaceholderConfigurer会非常的方便。由于这个原因，建议想要使用这个或者其他bean
        // factory postprocessor的用户使用ApplicationContext代替BeanFactroy。
//        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
//        DriverManagerDataSource dataSource2 = (DriverManagerDataSource) context.getBean("dataSource");
//        System.out.println(dataSource2.getUrl());
//        System.out.println(dataSource2.getUsername());
//        System.out.println(dataSource2.getPassword());
    }

}