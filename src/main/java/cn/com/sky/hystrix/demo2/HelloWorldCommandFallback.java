package cn.com.sky.hystrix.demo2;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * getFallback() 提供降级策略
 *
 * 除了HystrixBadRequestException异常之外，所有从run()方法抛出的异常都算作失败，并触发降级getFallback()和断路器逻辑。
 *
 * HystrixBadRequestException用在非法参数或非系统故障异常等不应触发回退逻辑的场景。
 *
 * </pre>
 */
public class HelloWorldCommandFallback extends HystrixCommand<String> {

    private final String name;

    public HelloWorldCommandFallback(String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("HelloWorldGroup"))
                /* 配置依赖超时时间,500毫秒*/
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(500)));
        this.name = name;
    }

    /**
     * 降级策略
     *
     * @return
     */
    @Override
    protected String getFallback() {
        return "exeucute Falled";
    }

    @Override
    protected String run() throws Exception {
        //sleep 1 秒,调用会超时
        TimeUnit.MILLISECONDS.sleep(1000);
        return "Hello " + name + " thread:" + Thread.currentThread().getName();
    }

    public static void main(String[] args) throws Exception {
        HelloWorldCommandFallback command = new HelloWorldCommandFallback("test-Fallback");
        String result = command.execute();
        System.out.println(result);
    }
}