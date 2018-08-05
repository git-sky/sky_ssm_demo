package cn.com.sky.spring.ioc.BeanFactoryPostProcessor.CustomEditorConfigurer;

import org.junit.Test;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.HashMap;
import java.util.Map;

public class TestPlaceholderConfigurer {

    private String getPath() {
        String path = TestPlaceholderConfigurer.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        return p;
    }

    @SuppressWarnings("deprecation")
    @Test
    public void test() {


        // 1.beanfactory
//		String configLocation = getPath() + "/conf.xml";
        String configLocation = "/conf.xml";

        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(configLocation));
        CustomEditorConfigurer configurer = new CustomEditorConfigurer();
        Map customerEditors = new HashMap();
        DatePropertyEditor propertyEditor = new DatePropertyEditor();
        propertyEditor.setDatePattern("yyyy/MM/dd");
        customerEditors.put("java.util.Date", propertyEditor);
        configurer.setCustomEditors(customerEditors);
        configurer.postProcessBeanFactory(beanFactory);

        DateFoo dateFoo = (DateFoo) beanFactory.getBean("dateFoo");
        System.out.println(dateFoo);
        System.out.println(dateFoo.getDate());


    }

}