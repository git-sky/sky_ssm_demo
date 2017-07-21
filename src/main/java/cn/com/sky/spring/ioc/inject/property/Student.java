package cn.com.sky.spring.ioc.inject.property;

public class Student {

	private String name;
	private int age;
	private School school;
	private Hobby hobby;

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public void setHobby(Hobby hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", school=" + school + ", hobby=" + hobby + "]";
	}

	// @Override
	// public String toString() {
	// StringBuilder stringBuilder = new StringBuilder();
	// stringBuilder.append("Student：" + "\n");
	// stringBuilder.append("name：" + name + "\n");
	// stringBuilder.append("age：" + age + "\n");
	// stringBuilder.append("school：" + school + "\n");
	// stringBuilder.append("hobby：" + hobby);
	// return stringBuilder.toString();
	// }

}