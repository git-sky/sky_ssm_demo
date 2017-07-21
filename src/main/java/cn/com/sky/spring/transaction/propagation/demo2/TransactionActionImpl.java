package cn.com.sky.spring.transaction.propagation.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("transactionAction")
public class TransactionActionImpl implements TransactionAction {

	@Autowired
	private TransactionService transactionService;

	@Override
	public void actionA() {

		transactionService.updateA();

//		try {
			transactionService.updateB();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	}

	@Override
	public void actionB() {
		transactionService.updateB();
	}

	@Override
	public void actionC() {
		transactionService.updateC();
	}

	@Override
	public void actionD() {
		transactionService.updateD();
	}

	@Override
	public void actionE() {
		transactionService.updateE();
	}

}