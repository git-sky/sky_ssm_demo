package cn.com.sky.spring.aop.aopconfig.demo;

public class Organizers {
	public void BeforeSong(String songName) {
		System.out.println("演唱会马上就开始了，演唱歌曲为: " + songName);
	}

	public void AfterSong() {
		System.out.println("演唱曲目结束，谢谢大家...");
	}
}