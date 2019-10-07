package ex1;

public class BinaryTreeSet extends BaseSet {
    class TreeNode {
        String val;
        TreeNode left;
        TreeNode right;

        public TreeNode(String val) {
            this.val = val;
        }
    }

    private TreeNode root;

    @Override
    public boolean add(String s) {
        if (s == null) return false;

        if (contains(s)) {
            return false;
        }

        size += 1;

        if (root == null) {
            root = new TreeNode(s);
        } else {
            TreeNode node = new TreeNode(s);
            node.left = root;
            root = node;
        }

        return true;
    }

    @Override
    public boolean contains(String s) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.val.equals(s)) {
                return true;
            }

            curr = curr.left;
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

}
