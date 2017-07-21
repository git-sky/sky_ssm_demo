package cn.com.sky.spring.jms.net2.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import cn.com.sky.spring.jms.net2.SenderApp;
import cn.com.sky.spring.jms.net2.jms.MessageSender;

/**
 * Unit test for simple SenderApp.
 */
public class SenderAppTest {

    @Test
    public void shouldGetMessageSender() throws Exception {
        MessageSender messageSender = SenderApp.getMessageSender("springJMSConfiguration.xml");
        assertNotNull("MessageSender shouldn't be null.",messageSender);
    }
}
