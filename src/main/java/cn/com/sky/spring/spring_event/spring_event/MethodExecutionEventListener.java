package cn.com.sky.spring.spring_event.spring_event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * 监听器
 */
public class MethodExecutionEventListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent evt) {
        if (evt instanceof MethodExecutionEvent) {
            // 执行处理逻辑
            System.out.println("MethodExecutionEventListener onApplicationEvent run..." + ((MethodExecutionEvent) evt).getMethodExecutionStatus());
        }
    }
}

