package cn.com.sky.jdbc;

public class Student {

    private Integer id;
    private String name;
    private Integer classId;

    public Student(String name, Integer classId) {
        super();
        this.name = name;
        this.classId = classId;
    }

    public Student(Integer id, String name, Integer classId) {
        super();
        this.id = id;
        this.name = name;
        this.classId = classId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

}