package cn.com.sky.spring.jms.net2.jms.retry;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.jms.support.JmsUtils;

public class MessageReceiver implements MessageListener {

    public void onMessage(Message message) {
        if(message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            try {
                String text = textMessage.getText();
                System.out.println(String.format("Received: %s",text));
                throw new JMSException("process failed");
            } catch (JMSException e) {
                System.out.println("there is JMS exception: " + e.getMessage() );
                throw JmsUtils.convertJmsAccessException(e);
            }
        }
    }
}
