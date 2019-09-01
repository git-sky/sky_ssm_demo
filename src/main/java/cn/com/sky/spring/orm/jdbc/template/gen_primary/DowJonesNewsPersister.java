package cn.com.sky.spring.orm.jdbc.template.gen_primary;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;

public class DowJonesNewsPersister {

    private DataFieldMaxValueIncrementer incrementer;

    private JdbcTemplate jdbcTemplate;



    public void insert(){
        jdbcTemplate.update("insert into fx_news(news_id,news_title,news_body) values(?,?,?)", new Object[]{incrementer.nextLongValue(), "title", "body"});
    }





    public DataFieldMaxValueIncrementer getIncrementer() {
        return incrementer;
    }

    public void setIncrementer(DataFieldMaxValueIncrementer incrementer) {
        this.incrementer = incrementer;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}