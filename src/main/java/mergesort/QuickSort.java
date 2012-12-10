package mergesort;

import java.util.Arrays;

public abstract class QuickSort {

    public abstract int[] quicksort(int[] list);

    protected AlgorithmResult algorithm(int[] list) {
        int pivot = list[list.length / 2];
        int i = 0;
        int j = list.length - 1;
        while (i <= j) {
            while (list[i] < pivot) {
                i++;
            }
            while (list[j] > pivot) {
                j--;
            }
            if (i <= j) {
                list = exchangeIn(list, i, j);
                i++;
                j--;
            }
        }
        return new AlgorithmResult(list, i, j);
    }

    protected static int[] combinePartialLists(int[] list, int[] listA, int endIndexA, int startIndexB, int[] listB) {
        list = overwriteList(list, 0, endIndexA, listA);
        list = overwriteList(list, startIndexB, list.length - 1, listB);
        return list;
    }

    protected static int[] subList(int[] list, int low, int high) {
        if (low >= high) {
            return new int[0];
        }
        return Arrays.copyOfRange(list, low, high + 1);
    }

    private static int[] overwriteList(int[] overwritedList, int startIndex, int endIndex, int[] overwritingList) {
        if (startIndex < endIndex) {
            System.arraycopy(overwritingList, 0, overwritedList, startIndex, overwritingList.length);
            return overwritedList;
        }
        return overwritedList;
    }

    private static int[] exchangeIn(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
        return list;
    }

    protected final class AlgorithmResult {

        final int[] list;
        final int i;
        final int j;

        private AlgorithmResult(int[] list, int i, int j) {
            this.list = list;
            this.i = i;
            this.j = j;
        }

        public int[] getList() {
            return list;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }
}
