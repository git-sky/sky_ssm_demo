package cn.com.sky.spring.ioc.autowire_xml;

public class Student {

    private String name;
    private int age;
    private School school;
    private Course course;

    public Student() {

    }

    public Student(School school, Course course) {
        this.school = school;
        this.course = course;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", school=" + school + ", course=" + course + "]";
    }
}