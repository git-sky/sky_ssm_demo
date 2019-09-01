package cn.com.sky.spring.orm.jdbc.template.gen_primary;


import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;
import org.springframework.jdbc.support.incrementer.MySQLMaxValueIncrementer;

/**
 * 使用MySQLMaxValueIncrementer生成递增主键并向关系数据库插入新增数据.
 */
public class TestProgrammaticPrimary {

    @Test
    public void test() {

        BasicDataSource dataSource = new BasicDataSource();

        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/springjdbc?characterEncoding=utf8&amp;zeroDateTimeBehavior=convertToNull&amp;allowMultiQueries=true";
        String username = "root";
        String password = "123456";

        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        DataFieldMaxValueIncrementer incrementer = new MySQLMaxValueIncrementer(dataSource, "fx_news_key", "value");
        ((MySQLMaxValueIncrementer) incrementer).setCacheSize(5);
        jdbcTemplate.update("insert into fx_news(news_id,news_title,news_body) values(?,?,?)", new Object[]{incrementer.nextLongValue(), "title", "body"});
    }
}