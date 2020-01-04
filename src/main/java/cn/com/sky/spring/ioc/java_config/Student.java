package cn.com.sky.spring.ioc.java_config;


public class Student {

    private String name;
    private int age;
    private School school;

    public Student(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public Student(School school) {
        super();
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", school=" + school + "]";
    }
}