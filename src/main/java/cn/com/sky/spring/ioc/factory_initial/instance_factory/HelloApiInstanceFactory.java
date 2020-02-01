package cn.com.sky.spring.ioc.factory_initial.instance_factory;

import cn.com.sky.spring.ioc.factory_initial.HelloApi;
import cn.com.sky.spring.ioc.factory_initial.HelloImpl;

/**
 * 非静态工厂方法(Instance Factory Method)
 */
public class HelloApiInstanceFactory {

    public HelloApi newInstance(String message) {
        return new HelloImpl(message);
    }

}
