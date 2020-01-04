package cn.com.sky;

import org.springframework.util.StopWatch;


public class TestStopWatch2 {

    public static void main(String[] argv) throws InterruptedException {
        TestStopWatch2 testStopWatch = new TestStopWatch2();
        testStopWatch.test();
    }

    private void test() throws InterruptedException {
        StopWatch sw = new StopWatch("a");

        sw.start("起床");
        Thread.sleep(1000);
        sw.stop();

        sw.start("洗漱");
        Thread.sleep(2000);
        sw.stop();

        sw.start("锁门");
        Thread.sleep(500);
        sw.stop();

        System.out.println(sw.prettyPrint());

        System.out.println("=============================================");
        System.out.println(sw.getTotalTimeMillis());
        System.out.println("=============================================");

        System.out.println(sw.getLastTaskName());
        System.out.println("=============================================");

        System.out.println(sw.getLastTaskInfo());
        System.out.println("=============================================");

        System.out.println(sw.getTaskCount());
        System.out.println("=============================================");

    }


}