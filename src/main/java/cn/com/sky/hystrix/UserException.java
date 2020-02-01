package cn.com.sky.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.junit.Assert;
import org.junit.Test;

public class UserException{

    @HystrixCommand(fallbackMethod = "fallback1")
    User getUserById(String id) {
        throw new RuntimeException("getUserById command failed");
    }

    @HystrixCommand(fallbackMethod = "fallback2")
    User fallback1(String id, Throwable e) {
        assert "getUserById command failed".equals(e.getMessage());
        throw new RuntimeException("fallback1 failed");
    }

    @HystrixCommand(fallbackMethod = "fallback3")
    User fallback2(String id) {
        throw new RuntimeException("fallback2 failed");
    }

    @HystrixCommand(fallbackMethod = "staticFallback")
    User fallback3(String id, Throwable e) {
        assert "fallback2 failed".equals(e.getMessage());
        throw new RuntimeException("fallback3 failed");
    }

    User staticFallback(String id, Throwable e) {
        assert "fallback3 failed".equals(e.getMessage());
        return new User("def", "def");
    }

    // test
    @Test
    public void test() {
        Assert.assertEquals("def", getUserById("1").getName());
    }

}