package mergesort;

public class ConcurrentSortTest extends SortTest {

    public ConcurrentSortTest() {
        quickSort = new ConcurrentQuickSort();
    }
}
