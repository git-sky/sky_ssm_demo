package cn.com.sky.spring.transaction.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 带事物回滚的测试基础类.
 * <p>
 * AbstractTransactionalJUnit4SpringContextTests类，默认回滚。
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/trans/aopconfig.xml"})
public class SpringTransactionalContextTests extends AbstractTransactionalJUnit4SpringContextTests {

}
