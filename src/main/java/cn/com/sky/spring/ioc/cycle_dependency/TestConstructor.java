package cn.com.sky.spring.ioc.cycle_dependency;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 构造器循环依赖，无法解决。
 * 
 * BeanCurrentlyInCreationException异常
 */
public class TestConstructor {

	private String getPath() {
		String path = TestConstructor.class.getPackage().getName();
		String p = path.replaceAll("\\.", "/");
		System.out.println(p);
		return p;
	}

	@Test
	public void testByConstructor() {

		new ClassPathXmlApplicationContext(getPath() + "/constructor.xml");

	}

}
