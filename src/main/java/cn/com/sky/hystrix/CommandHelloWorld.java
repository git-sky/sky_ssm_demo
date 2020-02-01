package cn.com.sky.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import rx.Observable;

import java.util.concurrent.Future;

public class CommandHelloWorld extends HystrixCommand<String> {

    private final String name;

    public CommandHelloWorld(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup")); //必须
        this.name = name;
    }

    @Override
    protected String run() {
        /*
         网络调用 或者其他一些业务逻辑，可能会超时或者抛异常
        */
        return "Hello " + name + "!";
    }

    public static void main(String[] args) {

        String s_execute = new CommandHelloWorld("Bob").execute();
        System.out.println("s_execute= " + s_execute);

        Future<String> s_queue = new CommandHelloWorld("Bob").queue();
        System.out.println("s_queue= " + s_queue);

        Observable<String> s_observe = new CommandHelloWorld("Bob").observe();
        System.out.println("s_observe= " + s_observe);

        Observable<String> toObservable = new CommandHelloWorld("Bob").toObservable();
        System.out.println("toObservable= " + toObservable);
    }

}