package cn.com.sky.spring.orm.jdbc.template;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class MyJdbcTemplate {

	JdbcTemplate jdbcTemplate;

	MyJdbcTemplate() {

		BasicDataSource dataSource = new BasicDataSource();

		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/springjdbc?characterEncoding=utf8&amp;zeroDateTimeBehavior=convertToNull&amp;allowMultiQueries=true";
		String username = "root";
		String password = "root";

		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);

		jdbcTemplate = new JdbcTemplate();

		jdbcTemplate.setDataSource(dataSource);
	}

}
