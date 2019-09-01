package cn.com.sky.spring.aop.annotation.scan.springUtil;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.sky.spring.aop.annotation.scan.UserDao;

public class Test2 {

    private SpringContextHelper helper;
    private SpringContextHelper2 helper2;
    ApplicationContext context;

    private static String getPath() {
        String path = Test2.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        System.out.println(p);
        return p;
    }

    @Before
    public void setUp() {
        String configLocation = getPath() + "/applicationContext.xml";
        context = new ClassPathXmlApplicationContext(configLocation);
        helper = (SpringContextHelper) context.getBean("springContextHelper");
        helper2 = (SpringContextHelper2) context.getBean("springContextHelper2");

    }

    public void tearDown() {
    }

    @Test
    public void testCase2() {
        UserDao userDao = (UserDao) helper.getBean("userDao");
        userDao.add();
        userDao.delete();
        userDao.update();
        userDao.query();

        try {
            // 测试异常捕获
            userDao.test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCase3() {
        UserDao userDao = (UserDao) helper2.getBean("userDao");
        userDao.add();
        userDao.delete();
        userDao.update();
        userDao.query();

        try {
            // 测试异常捕获
            userDao.test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}