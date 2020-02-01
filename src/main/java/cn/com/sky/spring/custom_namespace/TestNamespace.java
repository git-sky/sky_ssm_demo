package cn.com.sky.spring.custom_namespace;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 *
 *  自定义标签Namespace的步骤：
 * 1、设计配置属性和JavaBean；
 * 2、编写XSD文件；
 * 3、编写NamespaceHandler和BeanDefinitionParser完成解析工作；
 * 4、编写spring.handlers和spring.schemas串联起所有部件；
 * 5、在Bean文件中应用。
 *
 * </pre>
 */
public class TestNamespace {

    private static String getPath() {
        String path = TestNamespace.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        System.out.println(p);
        return p;
    }

    public static void main(String[] args) {

        String configLocation = getPath() + "/applicationContext.xml";

        ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);

        People p = (People) ctx.getBean("cutesource");
        System.out.println(p.getId());
        System.out.println(p.getName());
        System.out.println(p.getAge());

    }
}
