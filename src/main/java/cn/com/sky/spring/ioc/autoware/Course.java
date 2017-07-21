package cn.com.sky.spring.ioc.autoware;

public class Course {
	private String name;
	private double score;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Course [name=" + name + ", score=" + score + "]";
	}
}