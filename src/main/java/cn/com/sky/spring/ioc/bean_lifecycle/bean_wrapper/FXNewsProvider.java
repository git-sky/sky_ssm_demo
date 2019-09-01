package cn.com.sky.spring.ioc.bean_lifecycle.bean_wrapper;


public class FXNewsProvider {

    public IFXNewsListener newsListener;
    public IFXNewsPersister newPersistener;

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