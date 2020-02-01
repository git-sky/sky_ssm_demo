package cn.com.sky.spring.ioc.prototype_bug;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * 方式2：使用BeanFactoryAware。
 */
public class MockNewsPersister2 implements IFXNewsPersister, BeanFactoryAware {

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory bf) throws BeansException {
        this.beanFactory = bf;
    }

    public void persistNews(FXNewsBean bean) {
        persistNews();
    }

    public void persistNews() {
        System.out.println("persist bean:" + getNewsBean());
    }

    public FXNewsBean getNewsBean() {
        return (FXNewsBean) beanFactory.getBean("newsBean");
    }
}