package cn.com.sky.spring.orm.jdbc.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import cn.com.sky.spring.orm.jdbc.template.model.User;

public class UserDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void add(User user) {
		String sql = "insert into user(name,password,age) values(?,?,?)";
		jdbcTemplate.update(sql, user.getName(), user.getPassword(), user.getAge());
	}

	/**
	 * 用于查询的回调接口有三种定义:
	 * 
	 * 1.ResultSetExtractor
	 */
	public List<User> findByResultSetExtractor() {
		String sql = "select id,name,password,age from user";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<User>>() {
			@Override
			public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<User> users = new ArrayList<User>();
				while (rs.next()) {
					User user = new User();
					user.setName(rs.getString("name"));
					users.add(user);
				}

				return users;
			}
		});
	}

	/**
	 * 2.RowMapper
	 */
	public List<User> find() {
		String sql = "select id,name,password,age from user";
		return jdbcTemplate.query(sql, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setAge(rs.getInt("age"));
				return user;
			}
		});
	}

	/**
	 * 3.RowCallbackHandler
	 */
	public List<User> query() {
		String sql = "select id,name,password,age from user";
		final List<User> users = new ArrayList<User>();
		jdbcTemplate.query(sql, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				while (rs.next()) {
					User user = new User();
					user.setName(rs.getString("name"));
					users.add(user);
				}
			}
		});

		return users;

	}

	/**
	 * 按ID查询User表
	 */
	public User findById(String id) {
		String sql = "select id,name,password from user where id=?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		}, id);

	}

	public void updateByPreparedStatementSetter(final Integer id, final String name, final String password, final Integer age) {

		String sql = "UPDATE `springjdbc`.`user` SET `name` = ?, `password` = ?, `age` = ? WHERE `id` = ? ";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, name);
				ps.setString(2, password);
				ps.setInt(3, age);
				ps.setInt(4, id);
			}
		});

	}

	public void updateByPreparedStatementCreator(final Integer id, final String name, final String password, final Integer age) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = "UPDATE `springjdbc`.`user` SET `name` = ?, `password` = ?, `age` = ? WHERE `id` = ? ";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, password);
				ps.setInt(3, age);
				ps.setInt(4, id);
				return ps;
			}
		});
	}

	/**
	 * 更新数据的方法
	 * 
	 * @param user
	 */
	public void update(User user) {
		String sql = "update user set name=?,password=? where id=?";
		jdbcTemplate.update(sql, user.getName(), user.getPassword(), user.getId());
	}

	/**
	 * 删除数据的方法
	 * 
	 * @param id
	 */
	public void delete(String id) {
		String sql = "delete from user where id=?";
		jdbcTemplate.update(sql, id);
	}
}
