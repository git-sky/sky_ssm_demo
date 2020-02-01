package cn.com.sky.spring.ioc.cycle_dependency.demo;

import org.junit.Test;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;


/**
 * <pre>
 *
 * 原理参考：
 *
 * https://blog.csdn.net/u010853261/article/details/77940767
 *
 * https://www.iflym.com/index.php/code/201208280001.html
 *
 * </pre>
 */
public class TestBeanCycleDepend {

    private String getPath() {
        String path = TestBeanCycleDepend.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        return p;
    }

    @Test
    public void testBeanFactory() {
        String configLocation = getPath() + "/setter.xml";

//        Resource resource = new ClassPathResource(configLocation);
//        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
//        reader.loadBeanDefinitions(resource);
//        factory.addBeanPostProcessor(new MyBeanPostProcessor());

        ConfigurableBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(configLocation));

        for (int i = 1; i <= 3; i++) {
            TestA testA = (TestA) beanFactory.getBean("testA");
            System.out.println(testA);
        }


        //加上这个，才会执行销毁方法（DisposableBean -> destroy() 和 destroy-method ）
        beanFactory.destroySingletons();
    }
}