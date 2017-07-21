package cn.com.sky.spring.resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:cn/com/sky/spring/resource/applicationContext.xml")
public class Test1 {

	@Autowired
	private ClassA classA;

	@Test
	public void test() {
		classA.printContent();
	}

}