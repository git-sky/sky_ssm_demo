package cn.com.sky.spring.httpinvoker;

public class HttpInvokerTestImpl implements HttpInvokerTestI {

	@Override
	public String getTestPo(String desp) {
		return "getTestPo: " + desp;
	}

}
