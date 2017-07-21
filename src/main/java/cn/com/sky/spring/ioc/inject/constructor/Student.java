package cn.com.sky.spring.ioc.inject.constructor;

public class Student {

	private String name;
	private String company;
	private int age;
	private boolean sex;
	private School school;
	private Hobby hobby;

	public Student(String name, String company, int age, boolean sex) {
		this.name = name;
		this.company = company;
		this.age = age;
		this.sex = sex;
	}

	public Student(String name, String company) {
		this.name = name;
		this.company = company;
	}

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Student(int age, String company) {
		this.company = company;
		this.age = age;
	}

	public Student(String name, School school, int age) {
		this.name = name;
		this.school = school;
		this.age = age;
	}

	public Student(String name, School school, int age, Hobby hobby) {
		this.name = name;
		this.school = school;
		this.age = age;
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", company=" + company + ", age=" + age + ", sex=" + sex + ", school=" + school + ", hobby=" + hobby + "]";
	}

}