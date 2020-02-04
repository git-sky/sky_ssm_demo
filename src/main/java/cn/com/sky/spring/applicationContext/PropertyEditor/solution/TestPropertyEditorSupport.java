package cn.com.sky.spring.applicationContext.PropertyEditor.solution;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 解决方案1：
 * 使用自定义属性编辑器。（继承PropertyEditorSupport，重写setAsText。）
 */
public class TestPropertyEditorSupport {

    private static String getPath() {
        String path = TestPropertyEditorSupport.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        System.out.println(p);
        return p;
    }

    public static void main(String[] args) {

        String configLocation = getPath() + "/applicationContext.xml";

        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);

        UserManager sky = (UserManager) context.getBean("sky");
        System.out.println(sky);
    }
}