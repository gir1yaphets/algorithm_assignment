package ex1;

public class LinkedListSet extends BaseSet {
    class ListNode {
        String val;
        ListNode next;

        ListNode(String val) {
            this.val = val;
            next = null;
        }
    }

    private ListNode head;

    @Override
    public boolean add(String s) {
        if (s == null) throw new IllegalArgumentException("Add Invalid string in LinkedListSet");

        if (contains(s)) {
            return false;
        }

        size += 1;

        if (head == null) {
            head = new ListNode(s);
        } else {
            ListNode node = new ListNode(s);
            node.next = head;
            head = node;
        }

        return true;
    }

    @Override
    public boolean contains(String s) {
        ListNode cur = head;

        while (cur != null) {
            if (cur.val.equals(s)) {
                return true;
            }

            cur = cur.next;
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }
}
