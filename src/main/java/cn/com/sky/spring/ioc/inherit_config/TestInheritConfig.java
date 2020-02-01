package cn.com.sky.spring.ioc.inherit_config;


import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * <pre>
 *
 * 配置的继承，减少重复配置。
 *
 * 通过parent和abstract，来解决重复配置的问题。
 *
 * </pre>
 */
public class TestInheritConfig {

    private static String getPath() {
        String path = TestInheritConfig.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        System.out.println(p);
        return p;
    }

    @Test
    public void test() {

//        String configLocation = getPath() + "/config_duplicate.xml";

//        String configLocation = getPath() + "/config_parent.xml";
//
        String configLocation = getPath() + "/config_template.xml";


        BeanFactory beanFactory = new ClassPathXmlApplicationContext(configLocation);
        FXNewsProvider provider = beanFactory.getBean("subNewsProvider", FXNewsProvider.class);
//        provider
    }
}