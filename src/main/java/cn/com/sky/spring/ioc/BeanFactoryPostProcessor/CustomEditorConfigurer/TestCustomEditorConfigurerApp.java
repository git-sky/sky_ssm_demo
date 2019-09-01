package cn.com.sky.spring.ioc.BeanFactoryPostProcessor.CustomEditorConfigurer;

import org.junit.Test;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.util.HashMap;
import java.util.Map;


/**
 * <pre>
 *
 * 我们知道，不管对象是什么类型，也不管这些对象所声明的依赖对象是什么类型，通常都是通过XML（或者properties甚至其他媒介）文件格式来配置这些对象类型。
 *
 * 但XML所记载的，都是String类型，即容器从XML格式的文件中读取的都是字符串形式，最终应用程序却是由各种类型的对象所构成。
 *
 * 要想完成这种由字符串到具体对象的转换（不管这个转换工作最终由谁来做），都需要这种转换规则相关的信息，而CustomEditorConfigurer就是帮助我们传达类似信息的。
 *
 *
 *
 * Spring内部通过JavaBean的PropertyEditor来帮助进行String类型到其他类型的转换工作。
 *
 * 只要为每种对象类型提供一个PropertyEditor，就可以根据该对象类型取得与其相对应的 PropertyEditor来做具体的类型转换。
 * Spring容器内部在做具体的类型转换的时候，会采用JavaBean 框架内默认的PropertyEditor搜寻逻辑，从而继承了对原生类型以及java.lang.String.java.awt. Color和java.awt.Font等类型的转换支持。
 * 同时，Spring框架还提供了自身实现的一些PropertyEditor，这些PropertyEditor大部分都位于org.springframework.beans.propertyeditors包下。
 *
 * </pre>
 */
public class TestCustomEditorConfigurerApp {

    private String getPath() {
        String path = TestCustomEditorConfigurerApp.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        return p;
    }

    @Test
    public void test() {

        // 1.beanfactory
        String configLocation = getPath() + "/conf.xml";

        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
        DateFoo dateFoo = (DateFoo) context.getBean("dateFoo");
        System.out.println(dateFoo.getDate());


    }

}