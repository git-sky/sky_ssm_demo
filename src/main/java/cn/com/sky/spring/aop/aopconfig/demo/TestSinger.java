package cn.com.sky.spring.aop.aopconfig.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 *
 *  Spring只支持方法连接点.
 *
 * spring提供了4种各具特色的aop支持：
 *
 * a.基于代理的经典aop；
 *
 * b.@AspectJ注解驱动的切面；
 *
 * c.纯POJO切面
 *
 * d.注入式AspectJ切面（适合spring各版本）
 *
 *
 * </pre>
 */
public class TestSinger {

    private static String getPath() {
        String path = TestSinger.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        System.out.println(p);
        return p;
    }

    public static void main(String[] args) {

        String configLocation = getPath() + "/aop.xml";
        final ClassPathXmlApplicationContext act = new ClassPathXmlApplicationContext(configLocation);

        Singer singer = (Singer) act.getBean("singer");
        singer.perform("茉莉花");
    }

}
