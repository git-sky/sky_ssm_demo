package cn.com.sky.spring.orm.jdbc.template.programmatic;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.jdbc.object.SqlUpdate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * NamedParameterJdbcTemplate : 命名参数占位符；
 * NamedParameterJdbcTemplate内部持有JdbcTemplate。
 *
 * xx和yy就是命名参数；
 * String sql = "SELECT `id`, `name`, `password`, `age` FROM `springjdbc`.`user` where id=:xx and name=:yy";
 *
 * </pre>
 */
public class TestNamedParameterJdbcTemplate {

    static NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    static {

        BasicDataSource dataSource = new BasicDataSource();

        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/springjdbc?characterEncoding=utf8&amp;zeroDateTimeBehavior=convertToNull&amp;allowMultiQueries=true";
        String username = "root";
        String password = "123456";

        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);


        //1、MapSqlParameterSource的使用

        //xx和yy就是命名参数；
        String sql = "SELECT `id`, `name`, `password`, `age` FROM `springjdbc`.`user` where id=:xx and name=:yy";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("xx", "5");
        ((MapSqlParameterSource) sqlParameterSource).addValue("yy", "wang-0");

        List list = namedParameterJdbcTemplate.queryForList(sql, sqlParameterSource);
        System.out.println("list=" + list);


        Map<String, String> map = new HashMap<>();
        map.put("xx", "5");
        map.put("yy", "wang-0");


        List list2 = namedParameterJdbcTemplate.queryForList(sql, map);
        System.out.println("list2=" + list2);


        //2、BeanPropertySqlParameterSource的使用

        Param param = new Param();
        param.setXx("5");
        param.setYy("wang-0");

        //xx就是命名参数；
        SqlParameterSource beanPropertySqlParameterSource = new BeanPropertySqlParameterSource(param);
        List list3 = namedParameterJdbcTemplate.queryForList(sql, beanPropertySqlParameterSource);
        System.out.println("list3=" + list3);

    }

    private static class Param {
        private String xx;
        private String yy;

        public String getXx() {
            return xx;
        }

        public void setXx(String xx) {
            this.xx = xx;
        }

        public String getYy() {
            return yy;
        }

        public void setYy(String yy) {
            this.yy = yy;
        }
    }


    @Test
    public void query() {

    }
}