package cn.com.sky.spring.beanfactory;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.core.io.Resource;
 
/**
 * XmlBeanFactory是BeanFactory的最简单实现类
 * 
 * XmlBeanFactory的功能是建立在DefaultListableBeanFactory这个基本容器的基础上的，并在这个基本容器的基础上实行了其他诸如
 * XML读取的附加功能。XmlBeanFactory使用了DefaultListableBeanFactory作为基础类，DefaultListableBeanFactory是一个很重
 * 要的Ioc实现，会在下一章进行重点论述。
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @author Chris Beams
 * @since 15 April 2001
 */
public class XmlBeanFactory extends DefaultListableBeanFactory {
     
    private final XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(this);
 
    /**
     * 根据给定来源，创建一个XmlBeanFactory
     * @param resource  Spring中对与外部资源的抽象，最常见的是对文件的抽象，特别是XML文件。而且Resource里面通常
     * 是保存了Spring使用者的Bean定义，比如applicationContext.xml在被加载时，就会被抽象为Resource来处理。
     * @throws BeansException 载入或者解析中发生错误
     */
    public XmlBeanFactory(Resource resource) throws BeansException {
        this(resource, null);
    }
 
    /**
     * 根据给定来源和BeanFactory，创建一个XmlBeanFactory
     * @param resource  Spring中对与外部资源的抽象，最常见的是对文件的抽象，特别是XML文件。而且Resource里面通常
     * 是保存了Spring使用者的Bean定义，比如applicationContext.xml在被加载时，就会被抽象为Resource来处理。
     * @param parentBeanFactory 父类的BeanFactory
     * @throws BeansException 载入或者解析中发生错误
     */
    public XmlBeanFactory(Resource resource, BeanFactory parentBeanFactory) throws BeansException {
        super(parentBeanFactory);
        this.reader.loadBeanDefinitions(resource);
    }
}