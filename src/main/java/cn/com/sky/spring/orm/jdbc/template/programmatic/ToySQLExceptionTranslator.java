package cn.com.sky.spring.orm.jdbc.template.programmatic;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;

import java.sql.SQLException;


/**
 * 扩展SQLErrorCodeSQLExceptionTranslator，自定义异常转译。
 */
public class ToySQLExceptionTranslator extends SQLErrorCodeSQLExceptionTranslator {

    @Override
    protected DataAccessException customTranslate(String task, String sql, SQLException sqlEx) {
        if (sqlEx.getErrorCode() == 123456) {
            return new UncategorizedSQLException("abc", "", sqlEx);
        }
        return null;
    }
}