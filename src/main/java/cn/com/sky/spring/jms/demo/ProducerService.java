package cn.com.sky.spring.jms.demo;

import javax.jms.Destination;

public interface ProducerService {
    public void sendMessage(Destination destination, String message);
}