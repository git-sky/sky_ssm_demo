package cn.com.sky.spring.ioc.java_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <pre>
 *
 * 在XML配置中，Bean的类型和ID都是由Spring属性来表示的。Spring标识符的缺点是它们无法进行编译器检查。
 * 在Spring的基于Java的配置中并没有String属性。Bean的ID和类型都被视为方法签名的一部分。
 * Bean的实际创建是在方法体中定义的。因为它们全都是Java代码，所以我们可以进行编译器检查确保Bean的类型是合法类型，并且Bean的ID是唯一的。
 *
 * 基于Java的配置
 */
@Configuration
public class SpringConfig {

    // 等价于 <bean id = "studentBean" class = "cn.com.sky.spring.ioc.java_config.Student"></bean>
    // @Bean告知Spring这个方法将返回一个对象，该对象应该被注册为Spring应用上下文中的一个Bean。方法名作为该Bean的ID。
    // 在该方法中所实现的所有逻辑本质上都是为了创建Bean。
    // 该方法创建并返回一个Student的实例对象，该对象被注册为Spring应用上下文中ID为studentBean的Bean。
    @Bean
    public Student studentBean() {
        return new Student("yoona", 24);
    }

    @Bean
    public School schoolBean() {
        School school = new School();
        school.setName("西安电子科技大学");
        school.setLocation("西安");
        return school;
    }

    @Bean
    public Student yoonaStudent() {
        return new Student(schoolBean());
    }

}