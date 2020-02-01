package cn.com.sky.spring.aop_bug;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private IPersonDao personDao;

    @Override
    public String action(String msg) {
        System.out.println("action(String msg): " + msg);

//        this.work(msg);//代码1，会有嵌套方法不拦截问题。


        ((IPersonService) AopContext.currentProxy()).work(msg);   //代码2，解决嵌套方法不拦截问题。

        personDao.action(msg);


        return "[" + msg + "]";
    }

    @Override
    public String work(String msg) {
        System.out.println("work(String msg): " + msg);
        return "work: " + msg;
    }
}