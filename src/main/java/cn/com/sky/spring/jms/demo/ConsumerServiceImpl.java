package cn.com.sky.spring.jms.demo;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component("consumerService")
public class ConsumerServiceImpl implements ConsumerService {

	@Resource
	private JmsTemplate jmsTemplate;

	@Override
	public void consumeMessage(Destination destination) {

		while (true) {
			TextMessage message = (TextMessage) jmsTemplate.receive(destination);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			try {
				System.out.println("---------------消费者收到消息-----------------");
				System.out.println("recive:" + message.getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

}