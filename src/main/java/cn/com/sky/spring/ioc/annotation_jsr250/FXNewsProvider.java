package cn.com.sky.spring.ioc.annotation_jsr250;


import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class FXNewsProvider {

    //CommonAnnotationBeanPostProcessor 可以解析@Resource，但是解析不了@Autowired。
    @Resource
    private IFXNewsListener newsListener;

    //AutowiredAnnotationBeanPostProcessor 可以解析@Autowired，但解析不了@Resource。
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

//    public void setNewPersistener(IFXNewsPersister newPersistener) {
//        this.newPersistener = newPersistener;
//    }
}