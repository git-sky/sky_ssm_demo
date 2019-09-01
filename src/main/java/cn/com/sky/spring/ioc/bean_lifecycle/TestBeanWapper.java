package cn.com.sky.spring.ioc.bean_lifecycle;


import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.PropertyValue;

/**
 * BeanWrapper可以直接修改一个对象的属性。
 */
public class TestBeanWapper {

    public static void main(String[] args) {

        User user = new User();

        BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(user);
        bw.setPropertyValue("name", "zhangsan");
        System.out.println(user.getName());

        PropertyValue propertyValue = new PropertyValue("name", "lisi");
        bw.setPropertyValue(propertyValue);

        System.out.println(user.getName());

    }

}

