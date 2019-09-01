package cn.com.sky;


import org.springframework.util.StopWatch;

public class TestStopWatch {

    public static void main(String[] args) throws InterruptedException {
// 定义一个计数器
        StopWatch stopWatch = new StopWatch("统一一组任务耗时");

// 统计任务一耗时
        stopWatch.start("任务一");
        Thread.sleep(1000);
        stopWatch.stop();

// 统计任务二耗时
        stopWatch.start("任务二");
        Thread.sleep(2000);
        stopWatch.stop();

// 打印出耗时
        String result = stopWatch.prettyPrint();
        System.err.println(result);
    }
}