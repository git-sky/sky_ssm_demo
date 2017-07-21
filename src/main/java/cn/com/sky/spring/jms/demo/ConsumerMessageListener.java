package cn.com.sky.spring.jms.demo;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.jms.listener.SessionAwareMessageListener;

//消息驱动POJO
public class ConsumerMessageListener implements MessageListener {

	public void onMessage(Message message) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		// 这里我们知道生产者发送的就是一个纯文本消息，所以这里可以直接进行强制转换
		TextMessage textMsg = (TextMessage) message;
		System.out.println("消费者接收到一个纯文本消息。");
		try {
			System.out.println("消费者，消息内容是：" + textMsg.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
}