package cn.com.sky.spring.transaction.propagation.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionDao transactionDao;

	@Override
	public void updateA() {
		transactionDao.persistA();
		// throw new RuntimeException();
	}

	@Override
	public void updateB() {
//		try {
			transactionDao.persistB();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		// throw new RuntimeException();
	}

	@Override
	public void updateC() {
		transactionDao.persistC();
	}

	@Override
	public void updateD() {
		transactionDao.persistD();
	}

	@Override
	public void updateE() {
		transactionDao.persistE();
	}

}