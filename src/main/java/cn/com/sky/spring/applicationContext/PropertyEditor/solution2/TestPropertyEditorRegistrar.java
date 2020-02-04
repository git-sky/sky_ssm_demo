package cn.com.sky.spring.applicationContext.PropertyEditor.solution2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 解决方案2：
 * 注册spring自带的属性编辑器CustomDateEditor。
 */
public class TestPropertyEditorRegistrar {

    private static String getPath() {
        String path = TestPropertyEditorRegistrar.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        System.out.println(p);
        return p;
    }

    public static void main(String[] args) {

        String configLocation = getPath() + "/applicationContext.xml";

        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);

        UserManager sky = (UserManager) context.getBean("sky");
        System.out.println("sky= " + sky);
        System.out.println("dataValue= " + sky.getDataValue());
    }
}