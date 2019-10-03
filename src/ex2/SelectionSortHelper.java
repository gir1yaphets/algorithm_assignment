package ex2;

public class SelectionSortHelper extends BaseSortingHelper {
    @Override
    public void sort(String[] array) {
        selectionSort(array);
    }

    public void selectionSort(String[] array)
    {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i; j < array.length; j++) {
                if (isFormerLessThanLatter(array[j], array[min])) {
                    min = j;
                }

                //swap
                String temp = array[j];
                array[j] = array[min];
                array[min] = temp;
            }
        }
    }
}
