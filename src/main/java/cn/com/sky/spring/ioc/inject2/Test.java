package cn.com.sky.spring.ioc.inject2;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.sky.spring.ioc.inject2.constructor.MoAttack;

//import cn.com.sky.spring.ioc.inject2.property.MoAttack;

public class Test {

    private static String getPath() {
        String path = Test.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        System.out.println(p);
        return p;
    }

    public static void main(String[] args) {

        // 使用FileSystemXmlApplicationContext 和使用ClassPathXmlApplicationContext的区别在于:
        // FileSystemXmlApplicationContext 在指定的文件系统路径下查找applicationContext.xml 文件；
        // ClassPathXmlApplicationContext 是在所有的类路径（包含JAR 文件）下查找applicationContext.xml.xml 文件。

        // ClassPathXmlApplicationContext：ApplicationContext实现，从classpath获取配置文件；
        // ApplicationContext beanFactory = new
        // ClassPathXmlApplicationContext(getPath()+"/spring-property.xml");
        ApplicationContext beanFactory = new ClassPathXmlApplicationContext(getPath() + "/spring-constructor.xml");

        // FileSystemXmlApplicationContext：ApplicationContext实现，从文件系统获取配置文件。
        // ApplicationContext beanFactory = new
        // FileSystemXmlApplicationContext("/spring/ioc/spring.xml");

        // ApplicationContext接口获取Bean方法:

        // 1. Object getBean(String name) 根据名称返回一个Bean，客户端需要自己进行类型转换；
        // MoAttack attack = (MoAttack) beanFactory.getBean("moAttack");

        // 2. T getBean(String name, Class<T> requiredType)
        // 根据名称和指定的类型返回一个Bean，客户端无需自己进行类型转换，如果类型转换失败，容器抛出异常；
        // MoAttack attack = beanFactory.getBean("moAttack", MoAttack.class);

        // 3. T getBean(Class<T> requiredType)
        // 根据指定的类型返回一个Bean，客户端无需自己进行类型转换，如果没有或有多于一个Bean存在容器将抛出异常；
        // MoAttack attack = beanFactory.getBean(MoAttack.class);

        // 4. Map<String, T> getBeansOfType(Class<T> type) 根据指定的类型返回一个键值为名字和值为Bean对象的
        // Map，如果没有Bean对象存在则返回空的Map。
        Map<String, MoAttack> attackMap = beanFactory.getBeansOfType(MoAttack.class);
        MoAttack attack = attackMap.get("moAttack");

        // GeLi geli = (GeLi) beanFactory.getBean("geli");
        // attack.setGeli(geli);
        attack.cityGateAsk();
    }
}
