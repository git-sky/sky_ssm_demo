package cn.com.sky.spring.beanfactory.factory_bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class CarFactoryBean implements FactoryBean<Car>, InitializingBean {

    private String carInfo;

    @Override
    public Car getObject() throws Exception {
//        this.afterPropertiesSet();
        Car car = new Car();
        String[] infos = carInfo.split(",");
        car.setBrand(infos[0]);
        car.setMaxSpeed(Integer.valueOf(infos[1]));
        car.setPrice(Double.valueOf(infos[2]));
        System.out.println("getObject().......");
        return car;
    }

    @Override
    public Class<Car> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        //true是单例。false非单例。
        return false;
    }

    public String getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet....");
    }

    public void init() {
        System.out.println("init().....");
    }

}
