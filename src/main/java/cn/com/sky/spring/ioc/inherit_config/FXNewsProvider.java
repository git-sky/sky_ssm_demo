package cn.com.sky.spring.ioc.inherit_config;


public class FXNewsProvider {

    private IFXNewsListener newsListener;
    private IFXNewsPersister newPersistener;

    {
        System.out.println("new FXNewsProvider...");
    }

    public IFXNewsListener getNewsListener() {
        return newsListener;
    }

    public void setNewsListener(IFXNewsListener newsListener) {
        this.newsListener = newsListener;
    }

    public IFXNewsPersister getNewPersistener() {
        return newPersistener;
    }

    public void setNewPersistener(IFXNewsPersister newPersistener) {
        this.newPersistener = newPersistener;
    }
}