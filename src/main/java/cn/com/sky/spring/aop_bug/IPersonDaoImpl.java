package cn.com.sky.spring.aop_bug;

import org.springframework.stereotype.Repository;

@Repository
public class IPersonDaoImpl implements IPersonDao {

    @Override
    public String action(String msg) {
        System.out.println("IPersonDaoImpl action " + msg);
        return msg;
    }

    @Override
    public String work(String msg) {
        System.out.println("IPersonDaoImpl work " + msg);
        return msg;
    }
}