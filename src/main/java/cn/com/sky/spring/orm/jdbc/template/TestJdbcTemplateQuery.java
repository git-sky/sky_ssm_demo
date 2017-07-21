package cn.com.sky.spring.orm.jdbc.template;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class TestJdbcTemplateQuery extends MyJdbcTemplate {

	@Test
	public void query() {
		String sql = "SELECT `id`, `name`, `password`, `age` FROM `springjdbc`.`user`";

		List list = jdbcTemplate.queryForList(sql);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			System.out.println(object);
		}
	}
}
