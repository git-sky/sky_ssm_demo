package cn.com.sky.spring.ioc.hello;

public class HelloImpl implements HelloApi {
    @Override
    public void sayHello() {
        System.out.println("Hello World!");
    }

    public HelloImpl() {
        System.out.println("init HelloImpl ...");
    }
}