package cn.com.sky.spring.aop.annotation.scan;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 注解AOP实现（自动扫描方式）
 */
public class TestAutoProxyScan {

    private static String getPath() {
        String path = TestAutoProxyScan.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        System.out.println(p);
        return p;
    }

    public static void main(String[] args) {

        String configLocation = getPath() + "/aspectj-autoproxy-scan.xml";

        final ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext(configLocation);
        UserDao userDao = (UserDao) appCtx.getBean("userDao");
        userDao.add();
        userDao.delete();
        userDao.update();
        userDao.query();

        // try {
        // userDao.test();
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
    }
}