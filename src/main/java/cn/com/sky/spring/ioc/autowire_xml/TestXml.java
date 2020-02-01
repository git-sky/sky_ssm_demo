package cn.com.sky.spring.ioc.autowire_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 *
 * 除了可以通过配置明确指定bean之间的依赖关系，Spirng还提供了根据bean定义的某些特点将相互依赖的某些bean直接自动绑定的功能。
 *
 * Spring提供了4种自动装配策略【autowire】：
 *
 * 类型		说明
 * no
 * 默认方式[需要手工明确装配关系，非自动装配]，Bean的引用必须通过XML文件中的</ref>元素或者ref属性手动设定。
 *
 * byName
 * 把与Bean的属性具有相同名字（ID）的其他Bean自动装配到Bean对应属性中。如果没有跟属性的名字相匹配的Bean，则该属性不进行匹配。
 * 按照类中声明的实例变量的名称，与XML配置文件中声明的bean定义的beanName的值进行匹配，相匹配的bean定义将被自动绑定到当前实例变量上。
 *
 * byType
 * 把与Bean的属性具有相同类型的其他Bean自动装配到Bean对应属性中。如果没有跟属性的类型相匹配的Bean，则该属性不进行匹配。
 * 如果指定当前bean定义的autowire模式为byType，那么，容器会根据当前bean定义类型，分析其相应的依赖对象类型，
 * 然后到容器所管理的所有bean定义中寻找与依赖对象类型相同的bean定义，然后将找到的符合条件的bean自动绑定到当前bean定义。
 *
 * constructor
 * 把与Bean的构造器入参具有相同类型的其他Bean自动装配到Bean构造器对应入中。
 * byName和byType类型的自动绑定模式是针对property的自动绑定，而constructor类型则是针对构造方法参数的类型而进行的自动绑定，
 * 它同样是byType类型的绑定模式。不过，constructor是匹配构造方法的参数类型，而不是实例属性的类型。
 *
 *
 * 针对property的自动绑定：byName 和 byType；
 * 针对构造方法参数的自动绑定：constructor【基于构造方法的参数类型】；
 *
 *
 * 注意：
 * 1、手工明确指定的绑定关系总会覆盖自动绑定模式的行为。
 * 2、􏰂自动绑定只应用于“原生类型、String类型以及Classes类型以外”的对象类型，对“原生类型、String类型和Classes类型”以及“这些类型的数组”应用自动绑定是无效的。
 *
 *
 * Bean的自动装配 => xml配置方式
 *
 * xml的配置方式需要注意两个地方：
 * 1、xml中配置autowire的值【默认是no，需要手工配置装配关系】；
 * 2、bean中添加setter/getter方法。
 *
 * </pre>
 */
public class TestXml {

    private static ApplicationContext context;
    private static Student stu;

    private static String getPath() {
        String path = TestXml.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        System.out.println(p);
        return p;
    }

    public static void main(String[] args) {

//		 context = new
//		 ClassPathXmlApplicationContext(getPath() + "/byDefault.xml");

//        context = new
//                ClassPathXmlApplicationContext(getPath() + "/byName.xml");

//        context = new
//                ClassPathXmlApplicationContext(getPath() + "/byType.xml");

//         context = new
//         ClassPathXmlApplicationContext(getPath() + "/byTypePrimary.xml");

         context = new
         ClassPathXmlApplicationContext(getPath() + "/byTypeCandidate.xml");

//         context = new
//         ClassPathXmlApplicationContext(getPath() + "/byConstructor.xml");


//		context = new ClassPathXmlApplicationContext("/byDefault.xml");

        // 2. 从IOC容器中获取Bean实例
        stu = (Student) context.getBean("sky");
        // 3.调用方法
        System.out.println(stu);
        // 4.关闭容器
        ((ClassPathXmlApplicationContext) context).registerShutdownHook();

    }
}