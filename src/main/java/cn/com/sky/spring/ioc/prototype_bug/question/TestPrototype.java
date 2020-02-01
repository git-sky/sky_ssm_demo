package cn.com.sky.spring.ioc.prototype_bug.question;

import cn.com.sky.spring.ioc.prototype_bug.IFXNewsPersister;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * <pre>
 *
 * prototype的陷阱
 *
 *  scope="prototype"，但是每次返回同一个对象。
 *
 *
 * </pre>
 */
public class TestPrototype {

    private static String getPath() {
        String path = TestPrototype.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        System.out.println(p);
        return p;
    }

    @Test
    public void test() {
        String configLocation = getPath() + "/prototype.xml";

        BeanFactory container = new XmlBeanFactory(new ClassPathResource(configLocation));
        IFXNewsPersister persister = (MockNewsPersister) container.getBean("mockPersister");
        persister.persistNews();
        persister.persistNews();
    }
}