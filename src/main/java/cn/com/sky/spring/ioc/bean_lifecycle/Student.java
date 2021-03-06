package cn.com.sky.spring.ioc.bean_lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * <pre>
 *
 * Bean生命周期流程:
 *
 * Spring 对Bean进行实例化。
 * Spring 将值和Bean的引用注入进Bean对应的属性中。
 * 如果Bean 实现了BeanNameAware接口，Spring 将Bean的ID传递给setBeanName() 接口方法。
 * 如果Bean 实现了BeanFactoryAware接口，Spring 将调用setBeanFactory()接口方法，将BeanFactory 容器实例传入。
 * 如果Bean 实现了ApplicationContextAware 接口，Spring 将调用setApplicationContext()接口方法，将应用上下文的引用传入。
 * 如果容器存在实现了BeanPostProcessor 接口的类，Spring 将调用它们的postProcessBeforeInitialization() 接口方法。
 * 如果Bean 实现了InitializingBean 接口，Spring 将调用它们的afterPropertiesSet() 接口方法。类似地，如果Bean 使用init-method 声明了初始化方法，该方法也会被调用。
 * 如果容器存在实现了BeanPostProcessor 接口的类，Spring 将调用它们的postPoressAfterInitialization() 接口方法。
 * 此时此刻，Bean 已经准备就绪，可以被应用程序使用了，它们将一直驻留在应用上下文中，直到该应用上下文被销毁。
 * 如果Bean 实现了DisposableBean 接口，Spring 将调用它的destroy()接口方法。
 * 同样，如果Bean 使用destroy-method 声明了销毁方法，该方法也会被调用。
 *
 *
 *
 * 从这个运行结果中我们就可以看出一个Bean的生命周期：
 * constructor（实例化） ->
 * setXXX（填充属性） ->
 * BeanName（BeanNameAware接口） ->
 * BeanFactory（BeanFactoryAware接口） ->
 * ApplicationContext（ApplicationContextAware接口）->
 * postProcessBeforeInitialization（BeanPostProcessor接口） ->
 * afterPropertiesSet（InitializingBean接口）->
 * init-method（定制的初始化方法） ->
 * postProcessAfterInitialization（BeanPostProcessor接口） ->
 * destroy（DisposableBean接口） ->
 * destroy-method（定制的销毁方法）
 *
 * </pre>
 */
public class Student implements FactoryBean<Teacher>, BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    private String name;
    private int age;
    private String school;

    // 构造器
    public Student() {
        System.out.println("constructor Student() ");
    }

    public Student(String name, int age, String school) {
        super();
        this.name = name;
        this.age = age;
        this.school = school;
        System.out.println("constructor Student(String name, int age, String school) ");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("setName...");
    }

    public void setAge(int age) {
        this.age = age;
        System.out.println("setAge...");
    }

    public void setSchool(String school) {
        this.school = school;
        System.out.println("setSchool...");
    }

    public void say() {
        System.out.println("say() ......");
    }

    public void myInit() {
        System.out.println("init-method ...");
    }

    public void myDestroy() {
        System.out.println("destroy-method ...");
    }

    // 来自于BeanNameAware接口
    public void setBeanName(String beanName) {
        System.out.println("BeanNameAware -> setBeanName(String beanName)...[" + beanName + "]");
    }

    // 来自于BeanFactoryAware接口
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware -> setBeanFactory(BeanFactory beanFactory)...[" + beanFactory + "]");
    }

    // 来自于InitializingBean
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean -> afterPropertiesSet() ...");
    }

    // 来自于DisposableBean
    public void destroy() throws Exception {
        System.out.println("DisposableBean -> destroy() ...");
    }

    // 来自于ApplicationContextAware接口
    public void setApplicationContext(ApplicationContext arg0) throws BeansException {
        System.out.println("ApplicationContextAware -> setApplicationContext(ApplicationContext arg0)...[" + arg0 + "]");
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", school=" + school + "]";
    }

    // 来自于FactoryBean接口
    @Override
    public Teacher getObject() throws Exception {
        System.out.println("FactoryBean -> getObject() .........");
        return new Teacher("wang");
    }

    @Override
    public Class<Teacher> getObjectType() {
        System.out.println("FactoryBean -> getObjectType() ..........");
        return Teacher.class;
    }

    @Override
    public boolean isSingleton() {
        System.out.println("FactoryBean -> isSingleton() .........");
        return true;
    }

    public void study() {
        System.out.println("study englist.....");
    }
}