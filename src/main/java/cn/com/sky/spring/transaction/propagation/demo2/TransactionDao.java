package cn.com.sky.spring.transaction.propagation.demo2;

public interface TransactionDao {

	public void persistA();

	public void persistB();

	public void persistC();

	public void persistD();

	public void persistE();
}