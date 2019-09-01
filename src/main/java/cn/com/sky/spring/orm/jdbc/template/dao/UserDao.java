package cn.com.sky.spring.orm.jdbc.template.dao;

import cn.com.sky.spring.orm.jdbc.template.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    //===================查询======================//

    /**
     * 用于查询的回调接口有三种定义:
     * <p>
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
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setPassword(rs.getString("password"));
                    user.setAge(rs.getInt("age"));
                    users.add(user);
                }

                return users;
            }
        });
    }

    /**
     * 2.RowMapper
     */
    public List<User> findByRowMapper() {
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
     * 3.RowCallbackHandler 方式1
     */
    public List<User> findByRowCallbackHandler() {
        String sql = "select id,name,password,age from user";
        List collections = new ArrayList();
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                collections.add(user);
            }
        });
        return collections;
    }

    /**
     * 3.RowCallbackHandler 方式2
     */
    public List<User> findByRowCallbackHandler2() {
        String sql = "select id,name,password,age from user";
        GenericRowCallbackHandler handler = new GenericRowCallbackHandler();
        jdbcTemplate.query(sql, handler);
        return handler.getResults();
    }

    /**
     * 按ID查询User表
     */
    public User findById(String id) {
        String sql = "select id,name,password,age from user where id=?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int arg1) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                return user;
            }
        }, id);
    }


    //===================更新======================//

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


    //===================批量更新======================//

    public void insertBatch(List users) {
        jdbcTemplate.batchUpdate("INSERT INTO `user`(NAME,PASSWORD, age) VALUES(?,?,?)", new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                User user = (User) users.get(i);
                ps.setString(1, user.getName());
                ps.setString(2, user.getPassword());
                ps.setInt(3, user.getAge());
            }

            @Override
            public int getBatchSize() {
                return users.size();
            }
        });

    }

}
