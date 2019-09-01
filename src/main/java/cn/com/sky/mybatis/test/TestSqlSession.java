package cn.com.sky.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import cn.com.sky.mybatis.mapping.UserMapperI;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.com.sky.mybatis.domain.User;
import org.junit.Before;
import org.junit.Test;

/**
 * <pre>
 *
 *     参考：https://www.cnblogs.com/xdp-gacl/p/4261895.html
 *
 * </pre>
 */
public class TestSqlSession {

    SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void setUp() {

        // mybatis的配置文件
//        String resource = "mybatis/conf.xml";
//        // 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
//        InputStream is = TestSqlSession.class.getClassLoader().getResourceAsStream(resource);
//
//        // 构建sqlSession的工厂
//        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        // 使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        // Reader reader = Resources.getResourceAsReader(resource);
        // 构建sqlSession的工厂
        // SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);

        String resource = "cn/com/sky/mybatis/test/mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


    }

    @Test
    public void testSelect() {
        /**
         * 映射sql的标识字符串:
         * cn.com.sky.mybatis.mapping.userMapper 是 userMapper.xml 文件中 mapper 标签的 namespace 属性的值，
         * getUser 是 select 标签的 id 属性值，通过select标签的id属性值就可以找到要执行的SQL
         */

//        String statement = "cn.com.sky.mybatis.mapping.userMapper.getUser";
//        String statement = "cn.com.sky.mybatis.mapping.userMapper.getUserByInteger";
        String statement = "cn.com.sky.mybatis.mapping.userMapper.getUserByInteger2";

//        cn/com/sky/mybatis/mapping/userMapper.xml

        // 执行查询返回一个唯一user对象的sql
        // 创建能执行映射文件中sql的sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            User user = sqlSession.selectOne(statement, 1);
            System.out.println(user);
        } finally {
            sqlSession.close();
        }


        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
            User user = mapper.getById(1);
            System.out.println(user);
        } finally {
            session.close();
        }
    }

    @Test
    public void testAdd() {

//        String statement = "cn.com.sky.mybatis.mapping.userMapper.addUser";
//        String statement = "cn.com.sky.mybatis.mapping.userMapper.addUser2";
        String statement = "cn.com.sky.mybatis.mapping.userMapper.addUser3";


        User user = new User("zhaoliu", 12);

        SqlSession sqlSession = sqlSessionFactory.openSession();


        // 执行查询返回一个唯一user对象的sql
        for (int i = 1; i < 20; i++) {

            int count = sqlSession.insert(statement, user);
            System.out.println(count);
        }
        sqlSession.commit();
    }


    public static void main(String[] args) throws IOException {
        // mybatis的配置文件
        String resource = "mybatis/conf.xml";
        // 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = TestSqlSession.class.getClassLoader().getResourceAsStream(resource);

        // 构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        // 使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        // Reader reader = Resources.getResourceAsReader(resource);
        // 构建sqlSession的工厂
        // SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);

        // 创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();

        /**
         * 映射sql的标识字符串:
         * cn.com.sky.mybatis.mapping.userMapper 是 userMapper.xml 文件中 mapper 标签的 namespace 属性的值，
         * getUser 是 select 标签的 id 属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "cn.com.sky.mybatis.mapping.userMapper.getUser";

//        cn/com/sky/mybatis/mapping/userMapper.xml

        // 执行查询返回一个唯一user对象的sql
        for (int i = 1; i < 4; i++) {
            User user = session.selectOne(statement, i);
            System.out.println(user);
        }
    }
}