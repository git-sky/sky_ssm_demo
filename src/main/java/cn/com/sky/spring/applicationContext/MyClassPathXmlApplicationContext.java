package cn.com.sky.spring.applicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用该类时，需要定义var变量。
 */
public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {

    public MyClassPathXmlApplicationContext(String... configLocations) {
        super(configLocations);
    }

    /**
     * 实现该方法，自定义属性设置。位于prepareRefresh步骤中。
     */
    @Override
    protected void initPropertySources() {
        getEnvironment().setRequiredProperties("var");
    }

}
