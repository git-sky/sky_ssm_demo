package cn.com.sky.mybatis.book;

import cn.com.sky.mybatis.book.domain.Author;
import cn.com.sky.mybatis.book.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * <pre>
 *
 *     参考：https://www.cnblogs.com/xdp-gacl/p/4261895.html
 *
 * </pre>
 */
public class TestSelect {

    SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void setUp() {

        String resource = "cn/com/sky/mybatis/book/mybatis-config.xml";
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

        /*
         * <pre>
         * 映射sql的标识字符串:
         * cn.com.sky.mybatis.book.mapper.aaa.AuthorMapper 是 mapper_author.xml 文件中 mapper 标签的 namespace 属性的值，
         * selectAuthor 是 select 标签的 id 属性值，通过select标签的id属性值就可以找到要执行的SQL.
         * </pre>
         */
        String namespace = "cn.com.sky.mybatis.book.mapper.aaa.AuthorMapper";
        String id = "selectAuthor";
        String statement = namespace + "." + id;

        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //返回pojo类型
            Author author = sqlSession.selectOne(statement, 1);
            System.out.println(author);
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void testSelectMap() {

        String namespace = "cn.com.sky.mybatis.book.mapper.aaa.AuthorMapper";
        String id = "selectAuthorReturnMap";
        String statement = namespace + "." + id;

        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //返回map类型
            Map authorMap = sqlSession.selectOne(statement, 1);
            System.out.println(authorMap);
            System.out.println(authorMap.get("id"));
            System.out.println(authorMap.get("username"));
            System.out.println(authorMap.get("password"));
            System.out.println(authorMap.get("email"));
            System.out.println(authorMap.get("bio"));
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void selectAuthorReturnUser() {

        String namespace = "cn.com.sky.mybatis.book.mapper.aaa.AuthorMapper";
        String id = "selectAuthorReturnUser";
        String statement = namespace + "." + id;

        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            User user = sqlSession.selectOne(statement, 1);
            System.out.println(user);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void selectAuthorReturnUserByResultMap() {

        String namespace = "cn.com.sky.mybatis.book.mapper.aaa.AuthorMapper";
        String id = "selectAuthorReturnUserByResultMap";
        String statement = namespace + "." + id;

        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            User user = sqlSession.selectOne(statement, 1);
            System.out.println(user);
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void selectAuthorWithName() {

        String namespace = "cn.com.sky.mybatis.book.mapper.aaa.AuthorMapper";
        String id = "selectAuthorWithName";
        String statement = namespace + "." + id;

        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            Author author = sqlSession.selectOne(statement, "san");

            System.out.println(author);
        } finally {
            sqlSession.close();
        }
    }


//    @Test
//    public void testAdd() {
//
//
//        String namespace = "cn.com.sky.mybatis.book.mapper.aaa.AuthorMapper";
//        String id = "insertAuthorReturnKey";
//        String statement = namespace + "." + id;
//
//
//        Author author = new Author("lisi", "12", "12@123.com", "23");
//
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//
//
//        Author count = sqlSession.insert(statement, author);
//        System.out.println(count);
//
//        sqlSession.commit();
//    }


}