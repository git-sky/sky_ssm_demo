package cn.com.sky.spring.applicationContext.PropertyEditor;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * xml配置文件与UserManager类，类型不一致，转化失败。
 * 解决方案有两种：
 * 1、使用自定义属性编辑器。（继承PropertyEditorSupport，重写setAsText。）
 * 2、注册spring自带的属性编辑器CustomDateEditor。
 *
 * </pre>
 */
public class TestProperty {

    private static String getPath() {
        String path = TestProperty.class.getPackage().getName();
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
