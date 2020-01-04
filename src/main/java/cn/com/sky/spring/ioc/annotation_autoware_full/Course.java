package cn.com.sky.spring.ioc.annotation_autoware_full;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Course {
    @Value("my english")
    private String name;// // 通过实例域的注解实现注入,不用写方法。
    @Value("123")
    private double score;

    @Override
    public String toString() {
        return "Course [name=" + name + ", score=" + score + "]";
    }
}