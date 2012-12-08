package mergesort;

import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertTrue;

public class SerialTest {

    @Test
    public void testSerial() {
        final int listLength = 100000;
        final int nTries = 10;
        float[] times = new float[nTries];

        for (int tries = 0; tries < nTries; tries++) {
            int[] list = generateRandomList(listLength);
            long timeA = System.currentTimeMillis();
            int[] result = QuickSort.quicksort(list);
            long timeB = System.currentTimeMillis();
            assertTrue(validate(result));
            times[tries] = ((float) (timeB - timeA)) / 1000;
        }

        System.out.printf("Serial sorting in %.1f seconds.", average(times));
        System.out.printf("");
        System.out.printf("Result is an average of %d runs.", nTries);
        System.out.printf("List length was %d .", listLength);
    }

    private int[] generateRandomList(int length) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = ThreadLocalRandom.current().nextInt();
        }
        return result;
    }

    private boolean validate(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] > list[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private float average(float[] list) {
        float sum = 0;
        for (int i = 0; i < list.length; i++) {
            sum += list[i];
        }
        return sum / list.length;
    }
}
