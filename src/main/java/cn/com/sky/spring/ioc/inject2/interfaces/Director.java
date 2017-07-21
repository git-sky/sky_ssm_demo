package cn.com.sky.spring.ioc.inject2.interfaces;

import cn.com.sky.spring.ioc.inject2.GeLi;
import cn.com.sky.spring.ioc.inject2.LiuDeHua;

public class Director {
	public void direct() {
		GeLi geli = new LiuDeHua();
		MoAttack moAttack = new MoAttack();
		moAttack.injectGeli(geli);
		moAttack.cityGateAsk();
	}
}