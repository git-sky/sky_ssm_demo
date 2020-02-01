package cn.com.sky.spring.aop.annotation;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * 基于@AspectJ注解的AOP（注解AOP实现）
 *
 * 2、自动代理实现织入【织入器 AnnotationAwareAspectJAutoProxyCreator】
 *
 * <aop:aspectj-autoproxy/> 基于AnnotationAwareAspectJAutoProxyCreator
 *
 * </pre>
 */
public class TestAnnotation {

    private static String getPath() {
        String path = TestAnnotation.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        System.out.println(p);
        return p;
    }

    public static void main(String[] args) {

        AnnotationAwareAspectJAutoProxyCreator annotationAwareAspectJAutoProxyCreator=new AnnotationAwareAspectJAutoProxyCreator();

        String configLocation = getPath() + "/aspectj-autoproxy.xml";

        final ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext(configLocation);
        UserDao userDao = (UserDao) appCtx.getBean("userDao");
        // userDao.add();
        // userDao.delete();
        // userDao.update("a");
        // userDao.update();
        // userDao.query();

        try {
            userDao.test();
        } catch (Exception e) {
            // e.printStackTrace();
        }

    }
}