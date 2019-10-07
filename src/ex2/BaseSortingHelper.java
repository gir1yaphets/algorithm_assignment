package ex2;



public abstract class BaseSortingHelper {
    public abstract void sort(String[] array);

    public enum SortType {
        HEAP_SORT(0),
        INSERTION_SORT(1),
        MERGE_SORT(2),
        QUICK_SORT(3),
        SELECTION_SORT(4);

        private int value;

        SortType(int val) {
            this.value = val;
        }

        public int value() {
            return this.value;
        }

        public static SortType valueOf(int val) {
            switch (val) {
                case 0:
                    return HEAP_SORT;
                case 1:
                    return INSERTION_SORT;
                case 2:
                    return MERGE_SORT;
                case 3:
                    return QUICK_SORT;
                case 4:
                    return SELECTION_SORT;
                default:
                    return null;
            }
        }
    }

    public static BaseSortingHelper newInstance(SortType type) {
        switch (type) {
            case HEAP_SORT:
                return new HeapSortHelper();
            case INSERTION_SORT:
                return new InsertionSortHelper();
            case MERGE_SORT:
                return new MergeSortHelper();
            case QUICK_SORT:
                return new QuickSortHelper();
            case SELECTION_SORT:
                return new SelectionSortHelper();
        }

        return new HeapSortHelper();
    }

    public boolean isFormerBiggerThanLatter(String former, String latter) {
        if (former == null || latter == null) throw new IllegalArgumentException("Invalid input");

        return former.compareTo(latter) > 0;
    }

    public boolean isFormerLessThanLatter(String former, String latter) {
        if (former == null || latter == null) throw new IllegalArgumentException("Invalid input");

        return former.compareTo(latter) < 0;
    }

    public <T> void swap(T[] array, int a, int b) {
        T temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
