package ex2;

public class QuickSortHelper extends BaseSortingHelper {

    @Override
    public void sort(String[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(String[] array, int start, int end) {
        if (start >= end) return;

        int lo = start, hi = end;
        int ran = lo + (int)((hi - lo + 1)*Math.random());
        String pivot = array[ran];

        while (lo < hi) {
            while (lo < hi && isFormerBiggerThanLatter(array[hi], pivot)) {
                hi--;
            }

            array[lo] = array[hi];

            while (lo < hi && !isFormerBiggerThanLatter(array[lo], pivot)) {
                lo++;
            }

            array[hi] = array[lo];
        }

        array[lo] = pivot;

        quickSort(array, start, lo - 1);
        quickSort(array, lo + 1, end);
    }

}
