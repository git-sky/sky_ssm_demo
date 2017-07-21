package cn.com.sky.spring.ioc.inject2.property;

import cn.com.sky.spring.ioc.inject2.GeLi;

/**
 * 属性注入
 */
public class MoAttack {
	private GeLi geli;

	// ①属性注入方法
	public void setGeli(GeLi geli) {
		this.geli = geli;
	}

	public void cityGateAsk() {
		geli.responseAsk("墨者革离");
	}
}