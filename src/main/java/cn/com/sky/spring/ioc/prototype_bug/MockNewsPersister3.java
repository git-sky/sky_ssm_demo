package cn.com.sky.spring.ioc.prototype_bug;

import org.springframework.beans.factory.ObjectFactory;

/**
 * 方式3：使用ObjectFactory。
 */
public class MockNewsPersister3 implements IFXNewsPersister {

    private ObjectFactory newsBeanFactory;

    public void persistNews(FXNewsBean bean) {
        persistNews();
    }

    public void persistNews() {
        System.out.println("persist bean:" + getNewsBean());
    }

    public FXNewsBean getNewsBean() {
        return (FXNewsBean) newsBeanFactory.getObject();
    }

    public void setNewsBeanFactory(ObjectFactory newsBeanFactory) {
        this.newsBeanFactory = newsBeanFactory;
    }
}