package cn.com.sky.spring.util_properties;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUtil {

    private static String getPath() {
        String path = cn.com.sky.spring.util_properties.TestUtil.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        System.out.println(p);
        return p;
    }

    @Test
    public void test() {
        ApplicationContext app = new ClassPathXmlApplicationContext(getPath() + "/applicationContext.xml");

        Phone phone = app.getBean("phone", Phone.class);
        System.out.println(phone);
    }

}