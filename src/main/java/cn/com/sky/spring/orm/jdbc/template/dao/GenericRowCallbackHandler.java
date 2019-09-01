package cn.com.sky.spring.orm.jdbc.template.dao;

import cn.com.sky.spring.orm.jdbc.template.model.User;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GenericRowCallbackHandler implements RowCallbackHandler {

    private List collections = new ArrayList();

    @Override
    public void processRow(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));
        user.setAge(rs.getInt("age"));
        collections.add(user);
    }

    public List getResults() {
        return collections;
    }
}