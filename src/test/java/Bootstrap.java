

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bootstrap {
    final static CountDownLatch countDownLatch = new CountDownLatch(1);
    private static final Logger logger = LoggerFactory.getLogger(Bootstrap.class);

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("projectName", "rebate-service-impl");
        System.setProperty("appName", "gome_rebate_config_dev");
        System.setProperty("dubbo.port", "20889");
        final ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:/config/common/spring.xml");
        ac.start();
        logger.info("Shop TransactionService started successfully");
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                logger.info("Shutdown hook was invoked. Shutting down Shop TransactionService.");
                ac.close();
            }
        });

        countDownLatch.await();
    }

}
