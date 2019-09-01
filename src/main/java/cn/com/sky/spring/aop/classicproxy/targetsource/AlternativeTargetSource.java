package cn.com.sky.spring.aop.classicproxy.targetsource;

import org.springframework.aop.TargetSource;

public class AlternativeTargetSource implements TargetSource {

	private ITask one;
	private ITask two;

	private int counter;

	public AlternativeTargetSource(ITask one, ITask two) {
		super();
		this.one = one;
		this.two = two;
	}

	// 目标对象类型
	@Override
	public Class<?> getTargetClass() {
		return ITask.class;
	}

	// 是否返回同一个对象实例
	@Override
	public boolean isStatic() {
		return false;
	}

	// 返回目标对象实例
	@Override
	public Object getTarget() throws Exception {
		try {
			if (counter % 2 == 0) {
				return two;
			} else {
				return one;
			}

		} finally {
			counter++;
		}
	}

	// 释放当前调用的目标对象,isStatic()返回false的时候，才会执行。
	@Override
	public void releaseTarget(Object target) throws Exception {
		System.out.println("releaseTarget...");
	}

}
