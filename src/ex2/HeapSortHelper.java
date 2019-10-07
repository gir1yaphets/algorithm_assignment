package ex2;

public class HeapSortHelper extends BaseSortingHelper {
    @Override
    public void sort(String[] array) {
        heapSort(array);
    }

    public void heapSort(String[] array) {
        if (array == null || array.length == 1) return;
        buildArray2Heap(array);

        for (int i = array.length - 1; i >= 1; i--) {
            swap(array, 0, i);
            buildMaxHeap(array, i, 0);
        }
    }

    private void buildArray2Heap(String[] array) {
        if (array == null || array.length == 0) return;

        int mid = (array.length - 1) >> 1;
        for (int i = mid; i >= 0; i--) {
            buildMaxHeap(array, array.length, i);
        }
    }

    private void buildMaxHeap(String[] array, int heapSize, int start) {
        int maxIndex = start;
        int left = 2 * start + 1;
        int right = 2 * start + 2;

        //left > min
        if (left < heapSize && isFormerBiggerThanLatter(array[left], array[maxIndex])) {
            maxIndex = left;
        }

        //right > min
        if (right < heapSize && isFormerBiggerThanLatter(array[right], array[maxIndex])) {
            maxIndex = right;
        }

        if (maxIndex != start) {
            swap(array, maxIndex, start);
            buildMaxHeap(array, heapSize, maxIndex);
        }

    }
}
