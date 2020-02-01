package cn.com.sky.spring.beanfactory.normal;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class TestUseName {

    private static String getPath() {
        String path = TestUseName.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        System.out.println(p);
        return p;
    }

    public static void main(String[] args) {

        String configLocation = getPath() + "/use_name.xml";

        // 1.ResourceLoader
        ResourcePatternResolver resourceLoader = new PathMatchingResourcePatternResolver();
        // 2.Resource
        Resource resource = resourceLoader.getResource(configLocation);
        //
        // XmlBeanFactory beanFactory = new XmlBeanFactory(resource);

        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(configLocation));


        Student stu = (Student) beanFactory.getBean("sky");
        System.out.println(stu);

        Student stu2 = (Student) beanFactory.getBean("sky2");
        System.out.println(stu2);

        Student stu3 = (Student) beanFactory.getBean("sky3");
        System.out.println(stu3);

        Student stu5 = (Student) beanFactory.getBean("sky5");
        System.out.println(stu5);

        Student stu6 = (Student) beanFactory.getBean("sky6");
        System.out.println(stu6);

    }
}