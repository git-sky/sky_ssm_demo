package cn.com.sky.spring.jms.async.message_listener_adapter.adapter;

import java.util.Map;

public interface MessageDelegate2 {

    public abstract void processMessage(String message);

    public abstract void processMessage(byte[] message);

    public abstract void processMessage(Map message);

    public abstract void processMessage(Object message);

}