package mergesort;

public class QuickSort {

    public static int[] quicksort(int[] list) {
        if (list == null || list.length == 0 ) {
            return new int[0];
        }

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

        if (0 < j) {
            int[] sortedA = quicksort(subList(list, 0, j));
            list = overwriteList(list, 0, sortedA);
        }
        if (i < list.length - 1) {
            int[] sortedB = quicksort(subList(list, i, list.length - 1));
            list = overwriteList(list, i, sortedB);
        }
        return list;
    }

    private int[] quickSortPartial(int[] list, int low, int high) {
        if (low < high) {
            int[] subList = subList(list, low, high);
            int[] sortedA = quicksort(subList);
            return overwriteList(list, 0, sortedA);
        }
        return list;
    }

    private static int[] subList(int[] list, int low, int high) {
        int subListALength = high - low + 1;
        int[] subList = new int[subListALength];
        System.arraycopy(list, low, subList, 0, subListALength);
        return subList;
    }

    private static int[] overwriteList(int[] overwritedList, int startIndex, int[] overwritingList) {
        int[] result = overwritedList.clone();
        System.arraycopy(overwritingList, 0, result, startIndex, overwritingList.length);
        return result;
    }

    private static int[] exchangeIn(int[] list, int i, int j) {
        int[] result = list.clone();
        int temp = result[i];
        result[i] = result[j];
        result[j] = temp;
        return result;
    }
}
