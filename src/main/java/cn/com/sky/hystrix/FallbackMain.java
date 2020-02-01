package cn.com.sky.hystrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class FallbackMain {

//    private static final Logger LOG = LoggerFactory.getLogger(FallbackMain.class);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.submit(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                FallbackCommand command = new FallbackCommand("will-you-fallback");

                String result = command.execute();

                System.out.println("result=" + result);

//                LOG.info("{}", result);
                return "FALLBACK".equals(result);
            }
        });

        executorService.shutdown();

//        LOG.info("end");

//        System.exit(0);

    }
}