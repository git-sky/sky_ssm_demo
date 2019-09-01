package cn.com.sky.spring.orm.jdbc.template.gen_primary;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 递增主键生成策略的抽象.
 * 基于独立主键表的DataFieldMaxValueIncrementer.
 */
public class TestXmlPrimary {


    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(getPath() + "/app.xml");
        DowJonesNewsPersister persister = (DowJonesNewsPersister) applicationContext.getBean("djNewsPersister");
        persister.insert();

    }

    private static String getPath() {
        String path = TestXmlPrimary.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        System.out.println(p);
        return p;
    }
}