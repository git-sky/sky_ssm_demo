package cn.com.sky.spring.jms.net2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

import cn.com.sky.spring.jms.net2.jms.MessageSender;

public class SenderApp
{
    public static void main( String[] args ) throws IOException {
        start("springJMSConfiguration.xml");
    }

    public static void start(String configLocation) throws IOException {
        MessageSender sender = getMessageSender(configLocation);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please input your message:");
        String text = br.readLine();
        while (!StringUtils.isEmpty(text)) {
            System.out.println(String.format("send message: %s", text));
            sender.send(text);
            text = br.readLine();
        }
    }

    public static MessageSender getMessageSender(String configLocation) {
        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
        return (MessageSender) context.getBean("messageSender");

    }
}
