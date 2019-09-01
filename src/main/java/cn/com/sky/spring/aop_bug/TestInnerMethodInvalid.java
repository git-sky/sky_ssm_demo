package cn.com.sky.spring.aop_bug;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * 嵌套方法拦截失效问题。
 *
 * 解决方案
 * 需要修改两个地方：
 * 1、调用嵌套方法的地方修改为： ((IPersonService) AopContext.currentProxy()).work(msg);
 * 2、配置修改为：<aop:aspectj-autoproxy expose-proxy="true"/>
 *
 * </pre>
 */
public class TestInnerMethodInvalid {

    private static String getPath() {
        String path = TestInnerMethodInvalid.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        System.out.println(p);
        return p;
    }

    public static void main(String[] args) {

        String configLocation = getPath() + "/applicationContext.xml";
        final ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
        IPersonService personService = (IPersonService) applicationContext.getBean("personServiceImpl");
        personService.action("abc");
    }
}