package cn.com.sky.spring.ioc.inject2.interfaces;

import cn.com.sky.spring.ioc.inject2.GeLi;

/**
 * 接口注入
 */
public class MoAttack implements ActorArrangable {
	private GeLi geli;

	// ①实现接口方法
	public void injectGeli(GeLi geli) {
		this.geli = geli;
	}

	public void cityGateAsk() {
		geli.responseAsk("墨者革离");
	}
}