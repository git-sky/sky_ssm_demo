package cn.com.sky.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;

import java.util.concurrent.Future;

public class UserServiceAsync {

    @HystrixCommand
    public Future<User> getUserByIdAsync(final String id) {
        return new AsyncResult<User>() {
            @Override
            public User invoke() {
                return new User();
//                return userResource.getUserById(id);
            }
        };
    }
}