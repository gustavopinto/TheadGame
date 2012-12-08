package mergesort;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TimeTest extends QuickSortTestBase {

    private static final int LIST_LENGTH = 100000;
    private static final int N_TESTS = 10;

    @Test
    public void testSerialTime() {
        testTime(new SerialQuickSort());
    }

    @Test
    public void testConcurrentTime() {
        testTime(new ConcurrentQuickSort());
    }

    private void testTime(QuickSort quicksort) {
        float[] times = new float[N_TESTS];

        for (int tries = 0; tries < N_TESTS; tries++) {
            int[] list = generateRandomList(LIST_LENGTH);
            long timeA = System.currentTimeMillis();
            int[] result = quicksort.quicksort(list);
            long timeB = System.currentTimeMillis();
            assertNotNull(result);
            assertEquals(list.length, result.length);
            assertTrue(validateOrder(result));
            times[tries] = ((float) (timeB - timeA)) / 1000;
        }

        System.out.printf("%s sorting in %.1f seconds.\n", quicksort.getClass().getSimpleName(), average(times));
        System.out.printf("Result is an average of %d runs.\n", N_TESTS);
        System.out.printf("List length was %d .\n\n", LIST_LENGTH);
    }
}
