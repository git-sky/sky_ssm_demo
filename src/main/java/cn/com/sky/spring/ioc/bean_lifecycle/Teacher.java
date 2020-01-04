package cn.com.sky.spring.ioc.bean_lifecycle;

public class Teacher {

    private String name;

    // 构造器
    public Teacher() {
        System.out.println("constructor Teacher() ...");
    }

    public Teacher(String name) {
        super();
        this.name = name;
        System.out.println("constructor Teacher(String name) ...");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("setName...");
    }

    public String getName() {
        return name;
    }

    public void say() {
        System.out.println("say() ...");
    }

    @Override
    public String toString() {
        return "Teacher [name=" + name + "]";
    }

}