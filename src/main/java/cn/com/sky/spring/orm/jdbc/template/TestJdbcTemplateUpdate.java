package cn.com.sky.spring.orm.jdbc.template;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

public class TestJdbcTemplateUpdate extends MyJdbcTemplate {

	public void update() {

		String sql = "UPDATE `springjdbc`.`book` SET  `book_name` = ?, `price` = ? WHERE `isbn` = ? ";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, "C#");
				ps.setInt(2, 200);
				ps.setString(3, "1001");
			}
		});

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql2 = "UPDATE `springjdbc`.`book` SET  `book_name` = ?, `price` = ? WHERE `isbn` = ? ";
				PreparedStatement ps = con.prepareStatement(sql2);
				ps.setString(1, "C#");
				ps.setInt(2, 200);
				ps.setString(3, "1001");
				return ps;
			}
		});
	}
}
