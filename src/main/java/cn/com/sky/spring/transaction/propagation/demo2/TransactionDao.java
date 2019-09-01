package cn.com.sky.spring.transaction.propagation.demo2;

public interface TransactionDao {

    void persistA();

    void persistB();

    void persistC();

    void persistD();

    void persistE();
}