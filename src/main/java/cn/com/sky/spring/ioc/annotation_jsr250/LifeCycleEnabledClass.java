package cn.com.sky.spring.ioc.annotation_jsr250;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class LifeCycleEnabledClass {

    @PostConstruct
    public void setUp() {
        System.out.println("setUp..........");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy..........");
    }
}

