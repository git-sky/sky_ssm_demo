package cn.com.sky.spring.dao;

import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class Testa {

	public static void main(String[] args) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		StatementCallback callback = new StatementCallback<Object>() {
			public Object doInStatement(Statement stmt) {
				return null;
			}
		};
		jdbcTemplate.execute(callback);

		jdbcTemplate.queryForList("select * from a");

		DataSource ds = new com.mchange.v2.c3p0.ComboPooledDataSource();
		NamedParameterJdbcTemplate njt = new NamedParameterJdbcTemplate(ds);
	}
}
