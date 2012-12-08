package mergesort;

public class QuickSortBase {

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
        int[] result = list.clone();
        result = overwriteList(result, 0, endIndexA, listA);
        result = overwriteList(result, startIndexB, list.length - 1, listB);
        return result;
    }

    protected static int[] subList(int[] list, int low, int high) {
        int subListALength = high - low + 1;
        int[] subList = new int[subListALength];
        System.arraycopy(list, low, subList, 0, subListALength);
        return subList;
    }

    private static int[] overwriteList(int[] overwritedList, int startIndex, int endIndex, int[] overwritingList) {
        if (startIndex < endIndex) {
            int[] result = overwritedList.clone();
            System.arraycopy(overwritingList, 0, result, startIndex, overwritingList.length);
            return result;
        }
        return overwritedList;
    }

    private static int[] exchangeIn(int[] list, int i, int j) {
        int[] result = list.clone();
        int temp = result[i];
        result[i] = result[j];
        result[j] = temp;
        return result;
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
