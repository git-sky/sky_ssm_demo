package cn.com.sky.spring.dao;


import org.springframework.dao.ConcurrencyFailureException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.datasource.lookup.DataSourceLookupFailureException;

public class TestDataAccessException {

    public static void main(String[] args) {

        DataAccessException dataAccessException;
        DataAccessResourceFailureException dataAccessResourceFailureException;
        CannotGetJdbcConnectionException cannotGetJdbcConnectionException;
        DataSourceLookupFailureException dataSourceLookupFailureException;
        ConcurrencyFailureException concurrencyFailureException;

        DataIntegrityViolationException dataIntegrityViolationException;
    }
}