package cn.com.sky.spring;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * 执行顺序： Constructor >> @Autowired >> @PostConstruct
 */
public class AAA {

    @Autowired
    private BBB b;

    public AAA() {
        System.out.println("此时b还未被注入: b = " + b);
    }

    @PostConstruct
    private void init() {
        System.out.println("@PostConstruct将在依赖注入完成后被自动调用: b = " + b);
    }

}
