package cn.com.sky.spring.orm.jdbc.template.datasource;

import cn.com.sky.spring.orm.jdbc.template.dao.UserDao;
import cn.com.sky.spring.orm.jdbc.template.model.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.*;

import java.util.List;

/**
 * <pre>
 *
 * 自定义DataSource的两种方式：
 * 1、继承AbstractRoutingDataSource
 * 2、使用DelegatingDataSource
 *
 * </pre>
 */
public class TestDataSource {

    private static String getPath() {
        String path = TestDataSource.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        System.out.println(p);
        return p;
    }

    public static void main(String[] args) {

        String configLocation = getPath() + "/applicationContext.xml";
        System.out.println(configLocation);

        final ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext(configLocation);
        UserDao userDao = (UserDao) appCtx.getBean("userDaoDynamic");

        List<User> list = userDao.findByResultSetExtractor();
        for (User user2 : list) {
            System.out.println(user2);
        }

        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        SingleConnectionDataSource singleConnectionDataSource = new SingleConnectionDataSource();


//		DelegatingDataSource的子类
//         TransactionAwareDataSourceProxy
//        UserCredentialsDataSourceAdapter
//        LazyConnectionDataSourceProxy

    }

}
