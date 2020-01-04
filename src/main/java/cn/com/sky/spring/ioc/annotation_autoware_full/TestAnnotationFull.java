package cn.com.sky.spring.ioc.annotation_autoware_full;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.sky.spring.ioc.annotation_autoware.TestAnnotationConfig;

/**
 * <pre>
 *
 * 即使<context:annotation-config>有助于完全消除Spring注解中的<property>和<constructor-arg>元素，
 * 但是还是不能完全消除，仍然需要使用<bean>元素显示定义Bean。
 * 因此<context:component-scan>元素出现了，它除了完成<context:annotation-config>一样的工作，
 * 还允许Spring自动检测Bean和定义Bean。这就意味着我们不使用<bean>元素，Spring应用中的大多数（或者所有）Bean都能够实现定义和装配。
 *
 * <context:component-scan>元素会扫描指定的包以及所有子包，并查找出能够自动注册为Spring Bean的类。
 * base-package属性标示了<context:component-scan>元素所扫描的包。
 *
 * <context:include-filter>的type和expression属性一起协作来定义组件扫描策略。我们还可以选择如下任意一种过滤器：
 * 类型			说明
 * annotation	过滤器扫描使用指定注解标注的那些类，通过expression属性指定要扫描的注解
 * assignable	过滤器扫描派生于expression属性所指定类型的那些类。
 * aspectj		过滤器扫描与expression属性所指定的AspectJ表达式所匹配的那些类。
 * custom		使用自定义的org.springframework.core.type.TypeFilter实现类，该类由expression属性指定。
 * regex		过滤器扫描类的名称与expression属性所指定的正则表达式所匹配的那些类。
 *
 * </pre>
 */
public class TestAnnotationFull {

    private static ApplicationContext context;
    private static Student stu;
    private static School scl;
    private static Course crs;

    private static String getPath() {
        String path = TestAnnotationFull.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        System.out.println(p);
        return p;
    }

    public static void main(String[] args) {

        String configLocation = getPath() + "/annotation_full.xml";

        context = new ClassPathXmlApplicationContext(configLocation);

        // 1. 从IOC容器中获取Bean实例,但是xml文件并没有配置，是通过注解获取的bean。
        stu = (Student) context.getBean("student");
        stu.setName("Lisa");
        stu.setAge(23);
        System.out.println(stu);

        scl = (School) context.getBean("big");
        System.out.println(scl);

        crs = (Course) context.getBean("course");
        System.out.println(crs);

        // 2.关闭容器
        ((ClassPathXmlApplicationContext) context).registerShutdownHook();

    }
}