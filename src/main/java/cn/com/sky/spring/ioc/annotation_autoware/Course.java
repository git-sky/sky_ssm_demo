package cn.com.sky.spring.ioc.annotation_autoware;

import org.springframework.beans.factory.annotation.Value;

public class Course {
	@Value("my english")
	private String name;
	@Value("123")
	private double score;

//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public double getScore() {
//		return score;
//	}
//
//	public void setScore(double score) {
//		this.score = score;
//	}

	@Override
	public String toString() {
		return "Course [name=" + name + ", score=" + score + "]";
	}
}