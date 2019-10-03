package ex2;

public class InsertionSortHelper extends BaseSortingHelper {
    @Override
    public void sort(String[] array) {
        insertionSort(array);
    }

    private void insertionSort(String[] array) {
        for (int index = 1; index < array.length; index++) {
            int left = index - 1;
            String temp = array[index];

            while (left >= 0 && isFormerBiggerThanLatter(array[left], temp)) {
                array[left + 1] = array[left];
                left--;
            }

            array[left + 1] = temp;
        }
    }
}
