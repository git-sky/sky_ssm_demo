package cn.com.sky.spring.orm.jdbc.template;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.sky.spring.orm.jdbc.template.dao.UserDao;
import cn.com.sky.spring.orm.jdbc.template.model.User;

/**
 * xml配置JdbcTemplate。
 */
public class TestApplicationContext {

    ApplicationContext context = null;

    @Before
    public void setUp() {
        String configLocation = getPath() + "/applicationContext.xml";
        context = new ClassPathXmlApplicationContext(configLocation);
    }


    @Test
    public void testAdd() {
        UserDao dao = (UserDao) context.getBean("userDao");
        User user = new User();
        user.setName("spring");
        user.setPassword("spring");

        Random random = new Random();
        int age = random.nextInt(99);
        user.setAge(age);
        dao.add(user);
    }

    @Test
    public void testFind() {
        UserDao dao = (UserDao) context.getBean("userDao");
        List<User> list = dao.findByResultSetExtractor();
        for (User user : list) {
            System.out.println(user.getId() + ":" + user.getName() + ":" + user.getPassword());
        }

        System.out.println("========================");

        List<User> list2 = dao.findByRowMapper();
        for (User user : list2) {
            System.out.println(user.getId() + ":" + user.getName() + ":" + user.getPassword());
        }

        System.out.println("========================");

        List<User> list3 = dao.findByRowCallbackHandler();
        for (User user : list3) {
            System.out.println(user.getId() + ":" + user.getName() + ":" + user.getPassword());
        }

        System.out.println("========================");

        List<User> list4 = dao.findByRowCallbackHandler2();
        for (User user : list4) {
            System.out.println(user.getId() + ":" + user.getName() + ":" + user.getPassword());
        }

    }

    @Test
    public void testFindById() {
        UserDao dao = (UserDao) context.getBean("userDao");
        User user = dao.findById("1");
        System.out.println(user.getId() + ": " + user.getName() + ": " + user.getPassword() + ": " + user.getAge());
    }

    @Test
    public void testUpdateByPreparedStatementCreator() {
        UserDao dao = (UserDao) context.getBean("userDao");
        dao.updateByPreparedStatementCreator(1, "zhangsan", "123456", 23);

        User user = dao.findById("1");
        System.out.println(user.getId() + ": " + user.getName() + ": " + user.getPassword() + ": " + user.getAge());
    }

    @Test
    public void testUpdateByPreparedStatementSetter() {
        UserDao dao = (UserDao) context.getBean("userDao");
        dao.updateByPreparedStatementSetter(2, "lisi", "987654", 77);

        User user = dao.findById("2");
        System.out.println(user.getId() + ": " + user.getName() + ": " + user.getPassword() + ": " + user.getAge());
    }


    @Test
    public void testUpdate() {
        UserDao dao = (UserDao) context.getBean("userDao");
        User user = dao.findById("5");
        user.setName("Spring3");
        dao.update(user);
    }

    @Test
    public void testDelete() {
        UserDao dao = (UserDao) context.getBean("userDao");
        dao.delete("6");
    }


    @Test
    public void batch() {
        UserDao dao = (UserDao) context.getBean("userDao");
        List users = new ArrayList();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setName("wang-" + i);
            user.setPassword("wp-" + i);
            user.setAge(i);
            users.add(user);
        }

        dao.insertBatch(users);

    }


    private String getPath() {
        String path = TestApplicationContext.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        System.out.println(p);
        return p;
    }

}
