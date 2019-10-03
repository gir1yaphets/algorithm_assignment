package ex2;

public abstract class BaseSortingHelper {
    public abstract void sort(String[] array);

    public boolean isFormerBiggerThanLatter(String former, String latter) {
        if (former == null || latter == null) throw new IllegalArgumentException("Invalid input");

        return former.compareTo(latter) > 0;
    }

    public boolean isFormerLessThanLatter(String former, String latter) {
        if (former == null || latter == null) throw new IllegalArgumentException("Invalid input");

        return former.compareTo(latter) < 0;
    }
}
