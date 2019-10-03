package ex2;

public class MergeSortHelper extends BaseSortingHelper {
    @Override
    public void sort(String[] array) {
        String[] temp = new String[array.length];
        mergeSort(array, 0, array.length - 1, temp);
    }


    private void mergeSort(String[] array, int start, int end, String[] temp) {
        if (start < end) {
            int mid = (start + end) >> 1;
            mergeSort(array, start, mid, temp);
            mergeSort(array, mid + 1, end, temp);
            merge(array, start, mid, end, temp);
        }
    }

    private void merge(String[] array, int start, int mid, int end, String[] temp) {
        int left = start, right = mid + 1;
        int t = 0;

        while (left <= mid && right <= end) {
            if (isFormerBiggerThanLatter(array[left], array[right])) {
                temp[t++] = array[left++];
            } else {
                temp[t++] = array[right++];
            }
        }

        while (left <= mid) {
            temp[t++] = array[left++];
        }

        while (right <= end) {
            temp[t++] = array[right++];
        }

        t = 0;

        while (start <= end) {
            array[start++] = temp[t++];
        }
    }

}
