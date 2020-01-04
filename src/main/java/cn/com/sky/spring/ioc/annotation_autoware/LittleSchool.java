package cn.com.sky.spring.ioc.annotation_autoware;

public class LittleSchool extends School {
    private String name;
    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "School [name=" + name + ", location=" + location + "]";
    }
}