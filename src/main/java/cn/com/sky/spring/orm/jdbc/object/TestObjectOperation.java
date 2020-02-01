package cn.com.sky.spring.orm.jdbc.object;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.jdbc.object.SqlUpdate;

import java.util.Map;

/**
 * <pre>
 *
 * 操作对象的查询 SqlQuery
 *
 * 操作对象的更新 SqlUpdate
 *
 * 存储过程对象 StoredProcedure
 *
 * </pre>
 */
public class TestObjectOperation {

    public static void main(String[] args) {

        SqlQuery sqlQuery = new SqlQuery() {
            @Override
            protected RowMapper newRowMapper(Object[] parameters, Map context) {
                return null;
            }
        };

        SqlUpdate sqlUpdate = new SqlUpdate();


    }
}
