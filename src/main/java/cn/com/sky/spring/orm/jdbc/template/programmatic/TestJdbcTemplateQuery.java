package cn.com.sky.spring.orm.jdbc.template.programmatic;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

/**
 * 编码方式初始化 JdbcTemplate。
 */
public class TestJdbcTemplateQuery extends MyJdbcTemplate {

    @Test
    public void query() {
        String sql = "SELECT `id`, `name`, `password`, `age` FROM `springjdbc`.`user`";

        List list = jdbcTemplate.queryForList(sql);
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
            Object object = (Object) iterator.next();
            System.out.println(object);
        }
    }
}
