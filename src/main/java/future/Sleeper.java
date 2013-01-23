package future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sleeper {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sleeper.class);

    protected Object doStuff() throws InterruptedException {
        LOGGER.info("starting stuff");
        for (int i = 0; i < 10; i++) {
            Thread.sleep(100);
            Thread.yield();
        }
        LOGGER.info("ending stuff");
        return new Object();
    }
}