package mergesort;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TimeTest extends QuickSortTestBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimeTest.class);
    private static final int LIST_LENGTH = 50000;
    private static final int N_TESTS = 3;

    @Test
    public void testTimes() {
        float[] serialTimes = new float[N_TESTS];
        float[] concurrentTimes = new float[N_TESTS];
        for (int tries = 0; tries < N_TESTS; tries++) {
            int[] list = generateRandomList(LIST_LENGTH);
            serialTimes[tries] = testTime(new SerialQuickSort(), list);
            LOGGER.debug("{}. serial sorted.", tries + 1);
            concurrentTimes[tries] = testTime(new ConcurrentQuickSort(), list);
            LOGGER.debug("{}. concurrent sorted.", tries + 1);
        }
        LOGGER.info("Serial sorting in {}s.", average(serialTimes));
        LOGGER.info("Concurrent sorting in {}s.", average(concurrentTimes));
        LOGGER.info("Result is an average of {} runs.", N_TESTS);
        LOGGER.info("List length was {} .\n", LIST_LENGTH);
    }

    private float testTime(QuickSort quicksort, int[] list) {
        long timeA = System.currentTimeMillis();
        int[] result = quicksort.quicksort(list);
        long timeB = System.currentTimeMillis();
        assertNotNull(result);
        assertEquals(list.length, result.length);
        assertTrue(validateOrder(result));
        return ((float) (timeB - timeA)) / 1000;
    }
}
