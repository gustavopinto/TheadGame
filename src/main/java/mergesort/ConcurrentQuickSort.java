package mergesort;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ConcurrentQuickSort extends QuickSort {

    private static final int PARALLELISM = 16;
    private static final int FORKING_THRESHOLD = 312500;

    private ForkJoinPool pool = new ForkJoinPool(PARALLELISM);

    @Override
    public int[] quicksort(int[] list) {
        return pool.invoke(new SortingRecursiveTask(list));
    }

    private class SortingRecursiveTask extends RecursiveTask<int[]> {

        private int[] list;

        private SortingRecursiveTask(int[] list) {
            this.list = list;
        }

        @Override
        protected int[] compute() {
            if (list == null || list.length == 0 ) {
                return new int[0];
            }
            if (list.length == 1) {
                return list;
            }

            AlgorithmResult algorithmResult = algorithm(list);
            int[] list = algorithmResult.getList();
            int i = algorithmResult.getI();
            int j = algorithmResult.getJ();

            SortingRecursiveTask taskA = null;
            if (j > FORKING_THRESHOLD) {
                taskA = new SortingRecursiveTask(subList(list, 0, j));
                taskA.fork();
            }
            SortingRecursiveTask taskB = null;
            if (list.length - 1 - i > FORKING_THRESHOLD) {
                taskB = new SortingRecursiveTask(subList(list, i, list.length - 1));
                taskB.fork();
            }
            int[] sortedA = null;
            int[] sortedB = null;
            if (taskA == null) {
                sortedA = quicksort(subList(list, 0, j));
            }
            if (taskB == null) {
                sortedB = quicksort(subList(list, i, list.length - 1));
            }
            if (taskA != null) {
                sortedA = taskA.join();
            }
            if (taskB != null) {
                sortedB = taskB.join();
            }
            return combinePartialLists(list, sortedA, j, i, sortedB);
        }
    }
}
