package cn.com.sky.hystrix.thread_isolation;

import com.netflix.hystrix.*;

import java.util.concurrent.TimeUnit;

/**
 * 线程隔离
 */
public class CommandUsingThreadPoolIsolation extends HystrixCommand<String> {

    private final String name;

    public CommandUsingThreadPoolIsolation(String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))  //必须
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("ExampleGroup-pool"))  //可选,默认 使用 this.getClass().getSimpleName();
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(4)));

//        Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))  //必须
//                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
//                        .withExecutionTimeoutInMilliseconds(500))  //超时时间
//                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("ExampleGroup-pool"))  //可选,默认 使用 this.getClass().getSimpleName();
//                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(4)
//                        .withMaxQueueSize(10).withQueueSizeRejectionThreshold(7));

        this.name = name;
    }

    @Override
    protected String run() throws InterruptedException {
        System.out.println("running");
        TimeUnit.MILLISECONDS.sleep(1000);
        return "Hello " + name + "!";
    }

}