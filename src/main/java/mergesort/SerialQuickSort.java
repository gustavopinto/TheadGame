package mergesort;

public class SerialQuickSort extends QuickSort {

    public int[] quicksort(int[] list) {
        if (list == null || list.length == 0 ) {
            return new int[0];
        }
        if (list.length == 1) {
            return list;
        }

        AlgorithmResult algorithmResult = algorithm(list);
        list = algorithmResult.getList();
        int i = algorithmResult.getI();
        int j = algorithmResult.getJ();

        int[] sortedA = quickSortPartial(list, 0, j);
        int[] sortedB = quickSortPartial(list, i, list.length - 1);
        return combinePartialLists(list, sortedA, j, i, sortedB);
    }
}
