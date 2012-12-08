package mergesort;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public abstract class SortTest extends QuickSortTestBase {

    protected QuickSort quickSort;

    @Test
    public void testNormal() throws Exception {
        assertEquals(toList(new int[]{0, 1, 2, 6, 7, 9, 15}), toList(quickSort.quicksort(new int[]{2, 6, 1, 15, 9, 0, 7})));
    }

    @Test
    public void testInverse() throws Exception {
        assertEquals(toList(new int[]{0, 1, 2, 6, 7, 9, 15}), toList(quickSort.quicksort(new int[]{15, 9, 7, 6, 2, 1, 0})));
    }

    @Test
    public void testOne() throws Exception {
        assertEquals(toList(new int[]{1}), toList(quickSort.quicksort(new int[]{1})));
    }

    @Test
    public void testEmpty() throws Exception {
        assertTrue(quickSort.quicksort(new int[]{}).length == 0);
    }

    @Test
    public void testNull() throws Exception {
        assertTrue(quickSort.quicksort(null).length == 0);
    }

    @Test
    public void testEquals() throws Exception {
        assertEquals(toList(new int[]{1, 1, 1, 1, 1}), toList(quickSort.quicksort(new int[]{1, 1, 1, 1, 1})));
    }

    @Test
    public void testRandomLarge() throws Exception {
        for (int i = 0; i < 3; i++) {
            int[] list = generateRandomList(100);
            int[] result = quickSort.quicksort(list);
            assertNotNull(result);
            assertEquals(list.length, result.length);
            assertTrue(validateOrder(result));
        }
    }
}
