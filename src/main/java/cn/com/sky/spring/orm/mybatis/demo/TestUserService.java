package cn.com.sky.spring.orm.mybatis.demo;


import cn.com.sky.spring.orm.mybatis.demo.dao.UserMapper;
import cn.com.sky.spring.orm.mybatis.demo.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring+mybatis配置。
 *
 *
 */
public class TestUserService {

    private static String getPath() {
        String path = TestUserService.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        System.out.println(p);
        return p;
    }

    public static void main(String[] args) {

        String configLocation = getPath() + "/applicationContext.xml";

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
        System.out.println(userMapper);

        User user = userMapper.getUserById(1);
        System.out.println(user);
        System.out.println(user.getName());
        System.out.println(user.getAge());

    }
}