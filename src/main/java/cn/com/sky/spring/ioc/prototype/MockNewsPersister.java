package cn.com.sky.spring.ioc.prototype;

public class MockNewsPersister implements IFXNewsPersister {

    private FXNewsBean newsBean;

    public void persistNews(FXNewsBean bean) {
        persistNews();
    }

    public void persistNews() {
        System.out.println("persist bean:" + getNewsBean());
    }

    public FXNewsBean getNewsBean() {
        return newsBean;
    }

    public void setNewsBean(FXNewsBean newsBean) {
        this.newsBean = newsBean;
    }
}