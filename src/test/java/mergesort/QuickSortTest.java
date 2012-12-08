package mergesort;

import java.util.ArrayList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QuickSortTest {

    @Test
    public void testSim() throws Exception {
        assertEquals(toList(new int[]{ 0, 1, 2, 6, 7, 9, 15 }),
                toList(new QuickSort().quicksort(new int[]{ 2, 6, 1, 15, 9, 0, 7 })));
    }

    @Test
    public void testInverse() throws Exception {
        assertEquals(toList(new int[]{ 0, 1, 2, 6, 7, 9, 15 }),
            toList(new QuickSort().quicksort(new int[]{ 15, 9, 7, 6, 2, 1, 0 })));
    }

    @Test
    public void testOne() throws Exception {
        assertEquals(toList(new int[]{ 1 }),
                toList(new QuickSort().quicksort(new int[]{ 1 })));
    }

    @Test
    public void testEmpty() throws Exception {
        assertTrue(new QuickSort().quicksort(new int[]{ }).length == 0);
    }

    @Test
    public void testNull() throws Exception {
        assertTrue(new QuickSort().quicksort(null).length == 0);
    }

    @Test
    public void testEquals() throws Exception {
        assertEquals(toList(new int[]{ 1, 1, 1, 1, 1 }),
                toList(new QuickSort().quicksort(new int[]{ 1, 1, 1, 1, 1 })));
    }

    private ArrayList<Integer> toList(int[] array) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int k : array) {
            list.add(k);
        }
        return list;
    }
}
