package cn.com.sky.spring.ioc.inject2.constructor;

import cn.com.sky.spring.ioc.inject2.GeLi;
import cn.com.sky.spring.ioc.inject2.LiuDeHua;

public class Director {
	public void direct() {
		// ①指定角色的扮演者
		GeLi geli = new LiuDeHua();

		// ②注入具体扮演者到剧本中
		MoAttack moAttack = new MoAttack(geli);
		moAttack.cityGateAsk();
	}
}