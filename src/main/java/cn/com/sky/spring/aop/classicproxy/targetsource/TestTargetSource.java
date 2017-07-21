package cn.com.sky.spring.aop.classicproxy.targetsource;

import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.ProxyFactory;

public class TestTargetSource {

	public static void main(String[] args) {

		ITask task1 = new ITask() {
			@Override
			public void execute() {
				System.out.println("execute in task1 ...");
			}
		};

		ITask task2 = new ITask() {
			@Override
			public void execute() {
				System.out.println("execute in task2 ...");
			}
		};

		ProxyFactory pf = new ProxyFactory();
		TargetSource targetSource = new AlternativeTargetSource(task1, task2);
		pf.setTargetSource(targetSource);
		ITask proxy = (ITask) pf.getProxy();
		
		proxy.execute();
		proxy.execute();
		proxy.execute();
		proxy.execute();

	}

}
