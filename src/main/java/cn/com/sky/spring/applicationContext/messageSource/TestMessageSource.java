package cn.com.sky.spring.applicationContext.messageSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/**
 * 国际化支持。
 */
public class TestMessageSource {

    private static String getPath() {
        String path = TestMessageSource.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        System.out.println(p);
        return p;
    }

    public static void main(String[] args) {

        String configLocation = getPath() + "/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);

        String message2 = context.getMessage("msg.text", null, Locale.US);
        System.out.println(message2);

        String message3 = context.getMessage("msg.text", null, Locale.CHINA);
        System.out.println(message3);
    }
}