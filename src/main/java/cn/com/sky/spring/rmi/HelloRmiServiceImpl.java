package cn.com.sky.spring.rmi;

public class HelloRmiServiceImpl implements HelloRmiService {

	@Override
	public int add(int a, int b) {
		return a + b;
	}

}
