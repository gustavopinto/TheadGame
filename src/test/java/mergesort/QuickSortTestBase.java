package mergesort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSortTestBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuickSortTestBase.class);

    protected static int[] generateRandomList(int length) {
        long timeA = System.currentTimeMillis();
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = ThreadLocalRandom.current().nextInt();
        }
        long timeB = System.currentTimeMillis();
        LOGGER.info("{} random ints generated in {}s.", length, ((float) (timeB - timeA)) / 1000);
        return result;
    }

    protected static boolean validateOrder(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] > list[i + 1]) {
                return false;
            }
        }
        return true;
    }

    protected static ArrayList<Integer> toList(int[] array) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int k : array) {
            list.add(k);
        }
        return list;
    }

    protected static float average(float[] list) {
        float sum = 0;
        for (float x : list) {
            sum += x;
        }
        return sum / list.length;
    }
}
