package cn.com.sky.spring.beanfactory.programmatic;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import cn.com.sky.spring.beanfactory.programmatic.model.User;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * 2.b>加载xml配置文件的BeanFactory的使用
 */
public class TestByXmlFile {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
        BeanFactory container = bindViaXmlFile(beanRegistry);
        User user = (User) container.getBean("user");
        user.say();
    }

    public static BeanFactory bindViaXmlFile(BeanDefinitionRegistry registry) {
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
        String xmlPath = getPath() + "/config.xml";
        System.out.println(xmlPath);
        int loadCount = reader.loadBeanDefinitions(xmlPath);
        System.out.println(loadCount);
        return (BeanFactory) registry;
        // 或者直接
//         return new XmlBeanFactory(new ClassPathResource("../config.xml"));
    }

    private static String getPath() {
        String path = TestByXmlFile.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        System.out.println(p);
        return p;
    }

}
