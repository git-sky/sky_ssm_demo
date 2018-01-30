package cn.com.sky.spring.ioc.bean_lifecycle;

import org.junit.Test;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * <pre>
 * 
 * 测试Bean的生命周期
 * 
 * 将自定义的BeanPostProcessor注册到容器。 
 * 1.对于BeanFactory类型的容器来说，我们需要通过手工编码的方式将相应的BeanPostProcessor注册到容器，
 * 也就是调用ConfigurableBeanFactory的addBeanPostProcessor()方法，
 * 见如下代码：
 * ConfigurableBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(...));
 * beanFactory.addBeanPostProcessor(new MyBeanPostProcessor()); 
 * 
 * 2.对于ApplicationContext容器来说，事情则方便得多，直接将相应的BeanPostProcessor实现类通过通常的XML配置文件配置一下即可。
 * ApplicationContext容器会自动识别并加载注册到容器 的BeanPostProcessor，
 * 如下配置将MyBeanPostProcessor注册到容器：
 * <beans> 
 * 	<bean id="myBeanPostProcessor" class="cn.com.sky.spring.ioc.bean_lifecycle.MyBeanPostProcessor" />
 * <!--如果需要，注入必要的依赖--> 
 * </bean>
 * </beans>
 * 
 */
public class TestBeanLife {

	private String getPath() {
		String path = TestBeanLife.class.getPackage().getName();
		String p = path.replaceAll("\\.", "/");
		// System.out.println(p);
		return p;
	}

	@Test
	public void testApplicationContext() {

		String configLocation = getPath() + "/beanlife.xml";

		// 1.容器初始化
		System.out.println("=================1.容器初始化===================");
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);

		// 2. 从IOC容器中获取Bean实例
		System.out.println("==================2.从IOC容器中获取Bean实例==================");
		Teacher stu = (Teacher) context.getBean("sky");

		// 3.调用方法
		System.out.println("==================3.调用方法==================");
		System.out.println(stu);
		stu.say();

		// 4.关闭容器
		System.out.println("==================4.关闭容器==================");
		((ClassPathXmlApplicationContext) context).registerShutdownHook();

	}

	@Test
	public void testBeanFactory() {
		String configLocation = getPath() + "/beanlife.xml";

		ConfigurableBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(configLocation));

        beanFactory.

		beanFactory.addBeanPostProcessor(new MyBeanPostProcessor());
		// beanFactory.getBean("sky");
		Teacher teacher = (Teacher) beanFactory.getBean("teacher");
		System.out.println(teacher);
	}
}