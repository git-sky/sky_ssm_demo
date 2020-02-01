package cn.com.sky.spring.ioc.prototype_bug;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * <pre>
 *
 *
 * 拥有prototype类型scope的bean，在请求方每次向容器请求该类型对象的时候，容器都会返回一个全新的该对象实例。
 *
 * 本demo从输出看，对象实例是相同的，而这与我们的初衷是相悖的。
 *
 * 问：因为每次调用persistNews都会调用getNewsBean()方法并返回一个FXNewsBean实例，而FXNewsBean实例是prototype类型的，因此每次不是应该输出不同的对象实例嘛?
 *
 * 答：问题实际上不是出在FXNewsBean的scope类型是否是prototype的，而是出在实例的取得方式上面。
 * 虽然FXNewsBean拥有prototype类型的scope，但当容器将一个FXNewsBean的实例注入MockNewsPersister之后，MockNewsPersister就会一直持有这个FXNewsBean实例的引用。
 * 虽然每次输出都调用了getNewsBean()方法并返回了 FXNewsBean 的实例，但实际上每次返回的都是 MockNewsPersister持有的容器第一次注入的实例。
 * 这就是问题之所在。换句话说，第一个实例注入后，MockNewsPersister再也没有重新向容器申请新的实例。所以，容器也不会重新为其注入新的 FXNewsBean 类型的实例。
 *
 * 知道原因之后，我们就可以解决这个问题了。解决问题的关键在于保证getNewsBean()方法每次从容器中取得新的FXNewsBean实例，而不是每次都返回其持有的单一实例。
 *
 *
 * 解决方式：
 *
 * 1、方法注入
 * 只要让getNewsBean方法声明符合规定的格式，并在配置文件中通知容器，当该方法被调用的时候，每次返回指定类型的对象实例即可。
 * 方法声明需要符合的规格定义如下:
 * <public|protected> [abstract] <return-type> theMethodName(no-arguments);
 * 也就是说，该方法必须能够被子类实现或者覆写，因为容器会为我们要进行方法注入的对象使用 Cglib动态生成一个子类实现，从而替代当前对象。
 *
 * 通过<lookup-method>的name属性指定需要注入的方法名，bean属性指定需要注入的对象，当 getNewsBean方法被调用的时候，容器可以每次返回一个新的FXNewsBean类型的实例。
 *
 *
 * 2、使用BeanFactoryAware接口
 *
 * 3、使用ObjectFactoryCreatingFactoryBean类
 *
 * 4、方法替换 MethodReplacer（本demo没写）
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

//        IFXNewsPersister persister = (MockNewsPersister) container.getBean("mockPersister");

//        IFXNewsPersister persister = (MockNewsPersister2) container.getBean("mockPersister");


        IFXNewsPersister persister = (MockNewsPersister3) container.getBean("mockPersister");
        persister.persistNews();
        persister.persistNews();
    }
}