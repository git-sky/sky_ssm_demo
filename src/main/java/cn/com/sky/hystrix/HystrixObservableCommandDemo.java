package cn.com.sky.hystrix;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;

public class HystrixObservableCommandDemo extends HystrixObservableCommand {

    protected HystrixObservableCommandDemo(HystrixCommandGroupKey group) {
        super(group);
    }

    protected HystrixObservableCommandDemo(Setter setter) {
        super(setter);
    }

    @Override
    protected Observable construct() {
        return null;
    }
}