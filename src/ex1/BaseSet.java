package ex1;

import java.util.ArrayList;
import java.util.List;

import utils.CsvUtils;

public abstract class BaseSet {
    protected int size = 0;

    public enum SetType {
        LINKED_LIST_SET(0),
        BINARY_TREE_SET(1),
        HASH_TABLE_SET(2);

        private int value;

        SetType(int val) {
            this.value = val;
        }

        public int value() {
            return this.value;
        }

        public static SetType valueOf(int val) {
            switch (val) {
                case 0:
                    return LINKED_LIST_SET;
                case 1:
                    return BINARY_TREE_SET;
                case 2:
                    return HASH_TABLE_SET;
                default:
                    return null;
            }
        }
    }

    public static BaseSet newInstance(SetType type) {
        switch (type) {
            case LINKED_LIST_SET:
                return new LinkedListSet();
            case BINARY_TREE_SET:
                return new BinaryTreeSet();
            case HASH_TABLE_SET:
                return new HashTableSet();
        }

        return new LinkedListSet();
    }


    public abstract boolean add(String s);

    public abstract boolean contains(String s);

    public abstract int size();

    public int insert(String[] words) {
        int size;
        long start, end;

        List<List<String>> data = new ArrayList<>();

        for (String word : words) {
            start = System.nanoTime();
            boolean result = add(word);
            end = System.nanoTime();

            long duration = end - start;

            //make data for export
            if (result) {
                data.add(makeData(size(), duration));
            }
        }

        CsvUtils.print(data);
        size = size();

        return size;
    }

    private List<String> makeData(int size, long duration) {
        List<String> line = new ArrayList<>();
        line.add(String.valueOf(size));
        line.add(String.valueOf(duration));

        return line;
    }

    public int query(String[] words) {
        int count = 0;

        for (String word : words) {
            if (!contains(word)) {
                count++;
            }
        }

        return count;
    }
}
