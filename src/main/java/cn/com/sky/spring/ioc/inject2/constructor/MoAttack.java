package cn.com.sky.spring.ioc.inject2.constructor;

import cn.com.sky.spring.ioc.inject2.GeLi;

/**
 * 构造器注入
 */
public class MoAttack {

	private GeLi geli;

	// ①注入革离的具体扮演者
	public MoAttack(GeLi geli) {
		this.geli = geli;
	}

	public void cityGateAsk() {
		geli.responseAsk("墨者革离！");
	}
}