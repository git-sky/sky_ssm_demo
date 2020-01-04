package cn.com.sky.spring.transaction.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * AbstractJUnit4SpringContextTests类，不回滚。
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/trans/aopconfig.xml"})
public class SpringContextTests extends AbstractJUnit4SpringContextTests {

}
