package cn.com.sky.spring.jms.demo;

import javax.jms.Destination;

public interface ConsumerService {

	void consumeMessage(Destination destination);

}
