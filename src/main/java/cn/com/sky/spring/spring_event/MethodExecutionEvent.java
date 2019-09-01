package cn.com.sky.spring.spring_event;


import java.util.EventObject;

/**
 * 自定义的事件类型
 */
public class MethodExecutionEvent extends EventObject {

    private static final long serialVersionUID = -71960369269303337L;

    private String methodName;

    public MethodExecutionEvent(Object source) {
        super(source);
    }

    public MethodExecutionEvent(Object source, String methodName) {
        super(source);
        this.methodName = methodName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}