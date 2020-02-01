package cn.com.sky.hystrix.semaphore_isolation;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

/**
 * <pre>
 * 信号量隔离
 *
 * 信号量隔离的方式是限制了总的并发数，每一次请求过来，请求线程和调用依赖服务的线程是同一个线程，那么如果不涉及远程RPC调用（没有网络开销）则使用信号量来隔离，更为轻量，开销更小。
 *
 * </pre>
 */
public class CommandUsingSemaphoreIsolation extends HystrixCommand<String> {

    private final int id;

    public CommandUsingSemaphoreIsolation(int id) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                // since we're doing work in the run() method that doesn't involve network traffic
                // and executes very fast with low risk we choose SEMAPHORE isolation
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)));
        this.id = id;
    }

    @Override
    protected String run() {
        // a real implementation would retrieve data from in memory data structure
        // or some other similar non-network involved work
        return "ValueFromHashMap_" + id;
    }

}