package cn.com.sky.spring.applicationContext.initPropertySources;

import org.springframework.context.ApplicationContext;

public class TestInitPropertySources {

    private static String getPath() {
        String path = TestInitPropertySources.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        System.out.println(p);
        return p;
    }

    public static void main(String[] args) {

        String configLocation = getPath() + "/applicationContext.xml";

//        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);

        ApplicationContext context = new MyClassPathXmlApplicationContext(configLocation);

        // BeanFactory context = new XmlBeanFactory(new ClassPathResource(configLocation));

        Student sky = (Student) context.getBean("sky");
        System.out.println(sky);
    }

}
