package cn.com.sky.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;


public class FallbackCommand extends HystrixCommand<String> {

    public FallbackCommand(String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(name))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(500)));

    }

    @Override
    protected String getFallback() {
        return "FALLBACK";
    }

    @Override
    protected String run() throws Exception {
        return "SUCCEED RUN";
    }
}