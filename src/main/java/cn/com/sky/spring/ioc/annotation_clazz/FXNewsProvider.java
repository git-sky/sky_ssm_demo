package cn.com.sky.spring.ioc.annotation_clazz;


import org.springframework.beans.factory.annotation.Autowired;

public class FXNewsProvider {

    @Autowired
    private IFXNewsListener newsListener;
    @Autowired
    private IFXNewsPersister newPersistener;

    public IFXNewsListener getNewsListener() {
        return newsListener;
    }
//
//    public void setNewsListener(IFXNewsListener newsListener) {
//        this.newsListener = newsListener;
//    }

    public IFXNewsPersister getNewPersistener() {
        return newPersistener;
    }
//
//    public void setNewPersistener(IFXNewsPersister newPersistener) {
//        this.newPersistener = newPersistener;
//    }
}