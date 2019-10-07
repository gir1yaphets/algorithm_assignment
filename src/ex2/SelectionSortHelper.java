package ex2;

public class SelectionSortHelper extends BaseSortingHelper {
    @Override
    public void sort(String[] array) {
        if (array == null || array.length == 0) return;

        selectionSort(array);
    }

    public void selectionSort(String[] array)
    {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (isFormerLessThanLatter(array[j], array[min])) {
                    min = j;
                }

                //swap
                swap(array, i, min);
            }
        }
    }
}
