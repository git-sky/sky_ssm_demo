package cn.com.sky.spring.beanfactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.support.SimpleInstantiationStrategy;

/**
 * <pre>
 * 
 * BeanDefinition加入到注册中，并由BeanFactoryPostProcessor的实现类处理后，需要由InstantiationStrategy负责实例化。
 * 实例化仅仅是调用构造函数 ，相当于new了一个对象而已，bean的具体的属性在此时并未赋值 。
 * InstantiationStrategy负责由Bean类的默认构造函数、带参构造函数或者工厂方法等来实例化Bean。
 * 
 * </pre>
 */
public class TestInstantiationStrategy {

	private String name;

	private TestInstantiationStrategy() {
	}

	public TestInstantiationStrategy(String name) {
		this.name = name;
	}

	private TestInstantiationStrategy getIntance(String name) {
		return new TestInstantiationStrategy(name);
	}

	@Override
	public String toString() {
		return "name is " + name;
	}

	public static void main(String[] args) throws NoSuchMethodException {

		RootBeanDefinition definition = new RootBeanDefinition(TestInstantiationStrategy.class);

		SimpleInstantiationStrategy strategy = new SimpleInstantiationStrategy();

		// 因为没有用到BeanFactory和BeanName，所以参数中都设置为null
		// 默认构造器
		TestInstantiationStrategy test = (TestInstantiationStrategy) strategy.instantiate(definition, null, null);
		System.out.println(test);// 输出【name is null】

		// 带参数的构造器
		Constructor<TestInstantiationStrategy> constructor = TestInstantiationStrategy.class.getConstructor(String.class);
		TestInstantiationStrategy test2 = (TestInstantiationStrategy) strategy.instantiate(definition, null, null, constructor, new Object[] { "Jack" });
		System.out.println(test2);// 输出【name is Jack】

		// private的工厂方法
		Method method = TestInstantiationStrategy.class.getDeclaredMethod("getIntance", String.class);// 因为是private，所以要使用getDeclaredMethod
		TestInstantiationStrategy test3 = (TestInstantiationStrategy) strategy
				.instantiate(definition, null, null, new TestInstantiationStrategy(), method, new Object[] { "Lily" });
		System.out.println(test3);// 输出【name is Lily】

	}
}