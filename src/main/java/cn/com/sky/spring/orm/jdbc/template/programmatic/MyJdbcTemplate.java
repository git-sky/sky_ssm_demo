package cn.com.sky.spring.orm.jdbc.template.programmatic;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;

/**
 * 编码方式初始化 JdbcTemplate。
 */
public class MyJdbcTemplate {

    JdbcTemplate jdbcTemplate;

    MyJdbcTemplate() {

        BasicDataSource dataSource = new BasicDataSource();

        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/springjdbc?characterEncoding=utf8&amp;zeroDateTimeBehavior=convertToNull&amp;allowMultiQueries=true";
        String username = "root";
        String password = "123456";

        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        jdbcTemplate = new JdbcTemplate();

        jdbcTemplate.setDataSource(dataSource);


        //自定义异常转译
        SQLErrorCodeSQLExceptionTranslator sqlErrorCodeSQLExceptionTranslator = new MySQLExceptionTranslator();
        sqlErrorCodeSQLExceptionTranslator.setDataSource(dataSource);
        jdbcTemplate.setExceptionTranslator(sqlErrorCodeSQLExceptionTranslator);
    }

}
