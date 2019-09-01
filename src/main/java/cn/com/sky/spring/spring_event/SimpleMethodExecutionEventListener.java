package cn.com.sky.spring.spring_event;

/**
 * 自定义事件监􏰃器具体实现类SimpleMethodExecutionEventListener
 */
public class SimpleMethodExecutionEventListener implements MethodExecutionEventListener {

    public void onMethodBegin(MethodExecutionEvent evt) {
        String methodName = evt.getMethodName();
        System.out.println("start to execute the method[" + methodName + "].");
    }

    public void onMethodEnd(MethodExecutionEvent evt) {
        String methodName = evt.getMethodName();
        System.out.println("finished to execute the method[" + methodName + "].");
    }
}