package cn.com.sky.spring.ioc.bean_lifecycle.bean_wrapper;


import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.lang.reflect.Field;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

/**
 */
public class TestBeanWapper {

    // 使用BeanWrapper对bean实例操作很方便，可以免去直接使用Java反射API(Java Reflection API) 操作对象实例的烦琐。
    @Test
    public void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Object provider = Class.forName("cn.com.sky.spring.ioc.bean_lifecycle.bean_wrapper.FXNewsProvider").newInstance();
        Object listener = Class.forName("cn.com.sky.spring.ioc.bean_lifecycle.bean_wrapper.DowJonesNewsListener").newInstance();
        Object persister = Class.forName("cn.com.sky.spring.ioc.bean_lifecycle.bean_wrapper.DowJonesNewsPersister").newInstance();

        BeanWrapper newsProvider = new BeanWrapperImpl(provider);
        newsProvider.setPropertyValue("newsListener", listener);
        newsProvider.setPropertyValue("newPersistener", persister);


        assertTrue(newsProvider.getWrappedInstance() instanceof FXNewsProvider);
        assertSame(provider, newsProvider.getWrappedInstance());
        assertSame(listener, newsProvider.getPropertyValue("newsListener"));
        assertSame(persister, newsProvider.getPropertyValue("newPersistener"));
    }


    //直接使用Java反射API操作对象
    @Test
    public void testR() throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Object provider = Class.forName("cn.com.sky.spring.ioc.bean_lifecycle.bean_wrapper.FXNewsProvider").newInstance();
        Object listener = Class.forName("cn.com.sky.spring.ioc.bean_lifecycle.bean_wrapper.DowJonesNewsListener").newInstance();
        Object persister = Class.forName("cn.com.sky.spring.ioc.bean_lifecycle.bean_wrapper.DowJonesNewsPersister").newInstance();


        Class providerClazz = provider.getClass();
        Field listenerField = providerClazz.getField("newsListener");
        listenerField.set(provider, listener);
        Field persisterField = providerClazz.getField("newPersistener");
        persisterField.set(provider, persister);

        assertSame(listener, listenerField.get(provider));
        assertSame(persister, persisterField.get(provider));
    }
}