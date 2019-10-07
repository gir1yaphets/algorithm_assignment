package ex1;

public class HashTableSet extends BaseSet {
    private ListNode[] array;

    class ListNode {
        String val;
        ListNode next;

        ListNode(String val) {
            this.val = val;
            next = null;
        }
    }

    private static final int MOD = 200;

    public HashTableSet() {
        array = new ListNode[MOD];
    }

    @Override
    public boolean add(String s) {
        if (s == null) return false;

        if (contains(s)) {
            return false;
        }

        size += 1;
        int index = getIndex(s);

        if (array[index] == null) {
            array[index] = new ListNode(s);
        } else {
            ListNode curr = array[index];

            while (curr.next != null) {
                curr = curr.next;
            }

            curr.next = new ListNode(s);
        }

        return true;
    }

    private int getIndex(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            num += s.charAt(i);
        }

        return num % MOD;
    }

    @Override
    public boolean contains(String s) {
        int index = getIndex(s);

        if (array[index] == null) {
            return false;
        }

        ListNode curr = array[index];
        while (curr != null) {
            if (curr.val.equals(s)) {
                return true;
            }

            curr = curr.next;
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }
}
