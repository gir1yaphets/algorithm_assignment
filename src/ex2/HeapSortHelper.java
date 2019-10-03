package ex2;

public class HeapSortHelper extends BaseSortingHelper {
    @Override
    public void sort(String[] array) {
        buildArray2Heap(array);
    }

    private void buildArray2Heap(String[] array) {
        if (array == null || array.length == 0) return;

        int mid = array.length >> 1;
        for (int i = mid; i >= 0; i--) {
            buildMinHeap(array, 0);
        }
    }

    private void buildMinHeap(String[] array, int start) {
        int minIndex = start;
        int left = 2 * start + 1;
        int right = 2 * start + 2;

        if (left < array.length && isFormerBiggerThanLatter(array[minIndex], array[left])) {
            minIndex = left;
        }

        if (right < array.length && isFormerLessThanLatter(array[minIndex], array[right])) {
            minIndex = right;
        }

        if (minIndex != start) {
            String temp = array[minIndex];
            array[minIndex] = array[start];
            array[start] = temp;
            buildMinHeap(array, minIndex);
        }

    }
}
