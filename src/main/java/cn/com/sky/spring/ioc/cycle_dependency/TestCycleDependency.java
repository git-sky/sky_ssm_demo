package cn.com.sky.spring.ioc.cycle_dependency;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * 
 * 循环依赖问题解决（https://www.iflym.com/index.php/code/201208280001.html）：
 * 循环依赖是循环引用。不是循环调用，而循环调用是无法解决的，死循环，内存溢出。
 * 包括构造器循环依赖和setter循环依赖。
 * 正在创建的bean会放入“当前创建bean池”中，创建完毕后会清除出去。
 * a》构造器循环依赖是无法解决的，直接报错。
 * b》单例作用域的bean依赖。提前暴露一个单例工厂方法，从而使其他bean能够引用到该bean。
 * c》prototype的bean依赖无法解决。因为spring不缓存prototype范围的bean，因此无法提前暴露一个创建中的bean。
 * 
 * 
 * 
 * 构造器循环依赖，无法解决。
 * 
 * BeanCurrentlyInCreationException异常
 */
public class TestCycleDependency {

	private String getPath() {
		String path = TestCycleDependency.class.getPackage().getName();
		String p = path.replaceAll("\\.", "/");
		System.out.println(p);
		return p;
	}

	@Test
	public void testByConstructor() {
		new ClassPathXmlApplicationContext(getPath() + "/constructor.xml");
	}

	@Test
	public void testBySetter() {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(getPath() + "/setter.xml");
		appContext.getBean("testA");
	}
}
