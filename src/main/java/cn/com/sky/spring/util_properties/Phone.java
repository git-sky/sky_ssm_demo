package cn.com.sky.spring.util_properties;


import java.util.Properties;

public class Phone {

    private Properties properties;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "properties=" + properties +
                '}';
    }
}