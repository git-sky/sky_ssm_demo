package cn.com.sky.spring.ioc.inherit_config;


public class SpecificFXNewsProvider extends FXNewsProvider {

    private IFXNewsListener newsListener;
    private IFXNewsPersister newPersistener;

    {
        System.out.println("new SpecificFXNewsProvider...");
    }

    @Override
    public IFXNewsListener getNewsListener() {
        return newsListener;
    }

    @Override
    public void setNewsListener(IFXNewsListener newsListener) {
        this.newsListener = newsListener;
    }

    @Override
    public IFXNewsPersister getNewPersistener() {
        return newPersistener;
    }

    @Override
    public void setNewPersistener(IFXNewsPersister newPersistener) {
        this.newPersistener = newPersistener;
    }
}