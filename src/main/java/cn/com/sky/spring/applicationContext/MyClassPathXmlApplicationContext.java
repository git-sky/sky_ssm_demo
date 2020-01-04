package cn.com.sky.spring.applicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用该类时，需要定义var变量。
 */
public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {

    public MyClassPathXmlApplicationContext(String... configLocations) {
        super(configLocations);
    }

    protected void initPropertySources() {
        getEnvironment().setRequiredProperties("var");
    }

}
