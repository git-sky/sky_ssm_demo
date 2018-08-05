package cn.com.sky.spring.applicationContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

public class TestMethod {


    private static String getPath() {
        String path = Test.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        System.out.println(p);
        return p;
    }

    @SuppressWarnings({ "deprecation", "unused" })
    public static void main(String[] args) {

        String configLocation = getPath() + "/applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);

        Properties sysProps = (Properties) ctx.getBean("sysProps");
        System.out.println("Java version is " + sysProps.get("java.version"));
    }


}
