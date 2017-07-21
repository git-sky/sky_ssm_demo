package cn.com.sky.spring.orm.jdbc.object;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sky.spring.orm.jdbc.template.model.User;

public class UserDao {

	private UserMappingQuery userMappingQuery;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.userMappingQuery = new UserMappingQuery(dataSource);
	}

	public User getCustomer(Long id) {
		return userMappingQuery.findObject(id);
	}

	public List<User> getUsers(int age) {
		List<User> users = userMappingQuery.execute(age);
		return users;
	}

	public User getUser(Integer id) {
		Object[] parms = new Object[1];
		parms[0] = id;
		List<User> users = userMappingQuery.execute(parms);
		if (users.size() > 0) {
			return (User) users.get(0);
		} else {
			return null;
		}
	}

}
