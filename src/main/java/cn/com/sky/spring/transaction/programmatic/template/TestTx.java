package cn.com.sky.spring.transaction.programmatic.template;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTx {

    private static String getPath() {
        String path = TestTx.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        System.out.println(p);
        return p;
    }

    public static void main(String[] args) {

        String configLocation = getPath() + "/spring_template.xml";

        ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);

        BookShopService bookShopService = ctx.getBean(BookShopService.class);
//		bookShopService.purchase("Lucy", "1001");

        bookShopService.purchase2("Lucy", "1001");
    }
}
