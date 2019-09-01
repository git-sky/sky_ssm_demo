package cn.com.sky.spring.aop.classicproxy;

import cn.com.sky.spring.aop.classicproxy.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 *
 * 自动代理模式
 * 自动代理的原理都是基于BeanPostProcessor，通过干预对象实例化过程，生成代理对象。
 *
 * 所有的 AutoProxyCreator 都是 InstantiationAwareBeanPostProcessor，这种类型的 BeanPostProcessor
 * 与普通的BeanPostProcessor不一样。会直接使用 InstantiationAwareBeanPostProcessor 中的构造逻辑返回对象，
 * 不会走正常的实例化过程，也就是有“短路”行为。
 *
 * 常用的AutoProxyCreator类：
 * DefaultAdvisorAutoProxyCreator
 * BeanNameAutoProxyCreator
 * AnnotationAwareAspectJAutoProxyCreator --基于@Aspectj的Aop使用的自动代理模式
 *
 * </pre>
 */
public class TestAutoProxyCreator {

    private static String getPath() {
        String path = TestAutoProxyCreator.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        System.out.println(p);
        return p;
    }

    public static void main(String[] args) {

        String configLocation = getPath() + "/aop_autoproxy.xml";//自动代理模式

        final ApplicationContext appCtx = new ClassPathXmlApplicationContext(configLocation);
        UserDao userDao = (UserDao) appCtx.getBean("userDao");
        userDao.add();
        userDao.delete();
        userDao.update();
        userDao.query();


        try {
            userDao.test();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}