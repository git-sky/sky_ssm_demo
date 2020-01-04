package cn.com.sky.spring.ioc.annotation_autoware_full;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private String name;
    private int age;
    private School school;// 通过方法上的注解实现注入
    @Autowired
    private Course course;// 通过实例域的注解实现注入,不用写方法。

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public School getSchool() {
        return school;
    }

    /**
     * 使用@Autowired注解标注任意方法,不一定是set方法。
     *
     * <qualifier value="big"/>的Bean(优先级高) 或者id为big的Bean(优先级低)。
     */
    @Autowired
    @Qualifier("big")
    public void abc(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", school=" + school + ", course=" + course + "]";
    }
}