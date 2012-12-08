package mergesort;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSortTestBase {

    protected static int[] generateRandomList(int length) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = ThreadLocalRandom.current().nextInt();
        }
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
