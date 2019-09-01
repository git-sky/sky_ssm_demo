package cn.com.sky.spring.ioc.annotation_jsr250;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * <pre>
 * 我们只是使用@Resource或者@PostConstruct和@PreDestroy标注了相应对象，并不能给该对象带来想要的东西。
 *
 * 所以，就像@Autowired需要AutowiredAnnotationBeanPostProcessor为它与IoC容器牵线搭桥一样，
 *
 * JSR250的这些注解也同样需要一个BeanPostProcessor帮助它们实现自身的价值。
 *
 * 这个BeanPostProcessor就是org.springframework.context.annotation.CommonAnnotationBeanPostProcessor，
 *
 * 只有将CommonAnnotationBeanPostProcessor添加到容器，JSR250的相关注解才能发挥作用。
 *
 * 总结：
 * CommonAnnotationBeanPostProcessor 解析@Resource或者@PostConstruct和@PreDestroy注解。
 *
 * AutowiredAnnotationBeanPostProcessor 解析@Autowired和@Qualifier注解。
 *
 *
 * </pre>
 */
public class TestCommonAnnotationBeanPostProcessor {

    private static String getPath() {
        String path = TestCommonAnnotationBeanPostProcessor.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        System.out.println(p);
        return p;
    }

    public static void main(String[] args) {

        String configLocation = getPath() + "/annotation_jsr250.xml";

        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);

        FXNewsProvider provider = (FXNewsProvider) context.getBean("newsProvider");

        System.out.println(provider);
        System.out.println(provider.getNewsListener());
        System.out.println(provider.getNewPersistener());


        // 关闭容器
        ((ClassPathXmlApplicationContext) context).registerShutdownHook();
    }
}