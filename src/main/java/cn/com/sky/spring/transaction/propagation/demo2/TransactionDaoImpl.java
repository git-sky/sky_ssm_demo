package cn.com.sky.spring.transaction.propagation.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("transactionDao")
public class TransactionDaoImpl implements TransactionDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void persistA() {
        String sql = "update a set a = a+1";
        jdbcTemplate.update(sql);
    }

    @Override
    public void persistB() {
        String sql = "update b set b = b+1";
        jdbcTemplate.update(sql);
//        throw new RuntimeException();
    }

    @Override
    public void persistC() {
        String sql = "update c set c = c+1";
        jdbcTemplate.update(sql);

    }

    @Override
    public void persistD() {
        String sql = "update d set d = d+1";
        jdbcTemplate.update(sql);

    }

    @Override
    public void persistE() {
        String sql = "update e set e = e+1";
        jdbcTemplate.update(sql);

    }

}