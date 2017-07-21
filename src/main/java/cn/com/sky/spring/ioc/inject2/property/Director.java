package cn.com.sky.spring.ioc.inject2.property;

import cn.com.sky.spring.ioc.inject2.GeLi;
import cn.com.sky.spring.ioc.inject2.LiuDeHua;

public class Director {
	public void direct() {
		GeLi geli = new LiuDeHua();
		MoAttack moAttack = new MoAttack();

		// ①调用属性Setter方法注入
		moAttack.setGeli(geli);
		moAttack.cityGateAsk();
	}
}