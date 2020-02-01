package cn.com.sky.spring.ioc.annotation_autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * <pre>
 * 我们可以提供一个Spring的IoC容器使用的BeanPostProcessor自定义实现，让这个BeanPostProcessor在实例化bean定义的过程中，来检查当前对象是否有@Autowired标注的依赖需要注入。
 *
 * org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor就是Spring提供的用于这一目的的BeanPostProcessor实现。
 *
 * </pre>
 */
public class TestAutowiredAnnotationBeanPostProcessor {

    private static String getPath() {
        String path = TestAutowiredAnnotationBeanPostProcessor.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        System.out.println(p);
        return p;
    }

    public static void main(String[] args) {

        String configLocation = getPath() + "/annotation_autowired.xml";

        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);

        FXNewsProvider provider = (FXNewsProvider) context.getBean("newsProvider");

        System.out.println(provider);
        provider.send();


        //		AutowiredAnnotationBeanPostProcessor

    }
}