package cn.com.sky.spring.orm.jdbc.object;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import cn.com.sky.spring.orm.jdbc.template.model.User;

public class UserMappingQuery extends MappingSqlQuery<User> {

	public UserMappingQuery(DataSource ds) {
		super(ds, "select id,name,password,age from user where id=? ");
		super.declareParameter(new SqlParameter("id", Types.INTEGER));
		compile();
	}

	@Override
	protected User mapRow(ResultSet rs, int rowNumber) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		user.setAge(rs.getInt("age"));
		return user;
	}

}