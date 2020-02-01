package cn.com.sky.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

public class UserServiceFallbackMethod {

    private UserResource userResource;

    @HystrixCommand(fallbackMethod = "defaultUser")
    public User getUserById(String id) {
        return userResource.getUserById(id);
    }

    private User defaultUser(String id) {
        return new User("def", "def");
    }
}