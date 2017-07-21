package cn.com.sky.spring.aop.aopconfig.demo;

public class Singer {

	public void perform(String songName) {
		System.out.println("sing a song : " + songName);
//		throw new RuntimeException();
	}
}