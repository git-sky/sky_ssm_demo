package cn.com.sky.spring.ioc.annotation_jsr250.postconstruct;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * <pre>
 *
 * 我们只是使用 @Resource或者 @PostConstruct和 @PreDestroy 标注了相应对象，并不能给该对象带来想要的东西。
 *
 * 所以，就像 @Autowired需要AutowiredAnnotationBeanPostProcessor 为它与IoC容器牵线搭桥一样，
 *
 * JSR250 的这些注解也同样需要一个 BeanPostProcessor帮助它们实现自身的价值。
 *
 * 这个BeanPostProcessor 就是org.springframework.context.annotation.CommonAnnotationBeanPostProcessor，
 *
 * 只有将CommonAnnotationBeanPostProcessor 添加到容器，JSR250 的相关注解才能发挥作用。
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

        String configLocation = getPath() + "/anno.xml";

        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);


        AAA aaa = (AAA) context.getBean("abc");
        System.out.println(aaa);

        for (int i = 1; i < 99; i++) {
            aaa.send(i);
        }

        // 关闭容器（加上registerShutdownHook方法，注解@PreDestroy才会执行。）
        ((ClassPathXmlApplicationContext) context).registerShutdownHook();
    }
}