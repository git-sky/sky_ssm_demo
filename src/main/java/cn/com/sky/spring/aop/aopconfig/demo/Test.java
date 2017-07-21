package cn.com.sky.spring.aop.aopconfig.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * 
 *  Spring只支持方法连接点
 * 
 * Spring提供了4种各具特色的AOP支持：
 * 基于代理的经典AOP
 * @AspectJ注解驱动的切面
 * 纯POJO切面
 * 注入式AspectJ切面（适合Spring各版本）
 * 
 * 
 * 
 * 
 * 
 * </pre>
 */
public class Test {

	public static void main(String[] args) {
		final ClassPathXmlApplicationContext act = new ClassPathXmlApplicationContext("cn/com/sky/spring/aop/demo2/xml/aop.xml");

		Singer singer = (Singer) act.getBean("singer");
		singer.perform("茉莉花");
	}

}
