package cn.com.sky.spring.aop.classicproxy;

import cn.com.sky.spring.aop.classicproxy.dao.UserDao;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * <pre>
 *
 * 3、自动代理模式织入【织入器DefaultAdvisorAutoProxyCreator】
 *
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
        //自动代理模式
        String configLocation = getPath() + "/aop_autoproxy.xml";

        System.out.println(configLocation);

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