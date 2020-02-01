package cn.com.sky.spring.ioc.annotation_autowired;


import org.springframework.beans.factory.annotation.Autowired;

public class FXNewsProvider {
    @Autowired
    private IFXNewsListener newsListener;
    @Autowired
    private IFXNewsPersister newPersistener;

    public void send() {
        System.out.println(newsListener);
        System.out.println(newPersistener);
    }
}