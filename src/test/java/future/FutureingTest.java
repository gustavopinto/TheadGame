package future;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FutureingTest {

    @Test
    public void test() throws Exception {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(8, 8, 0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());
        List<Future> futures = new ArrayList<Future>();
        for (int i = 0; i < 16; i++) {
            futures.add(threadPoolExecutor.submit(new RunnableSleeper()));
        }
        for (Future future : futures) {
            future.get(1500, TimeUnit.MILLISECONDS);
        }
    }

    @Test
    public void test2() throws Exception {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 1, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());
        List<Future> futures = new ArrayList<Future>();
        for (int i = 0; i < 5; i++) {
            futures.add(threadPoolExecutor.submit(new RunnableSleeper()));
            Thread.sleep(500);
        }
        for (Future future : futures) {
            future.get(1500, TimeUnit.MILLISECONDS);
        }
    }
}
