package cn.com.sky.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

public class UserServiceSync {

    @HystrixCommand
    public User getUserById(String id) {
        return new User();
//        return userResource.getUserById(id);
    }
}