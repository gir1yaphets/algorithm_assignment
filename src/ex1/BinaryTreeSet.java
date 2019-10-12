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
            insertNode(root, s);
        }

        return true;
    }

    private TreeNode insertNode(TreeNode node, String s) {
        if (node == null) {
            return new TreeNode(s);
        }

        if (node.val.compareTo(s) > 0) {
            node.left = insertNode(node.left, s);
        } else {
            node.right = insertNode(node.right, s);
        }

        return node;
    }

    @Override
    public boolean contains(String s) {
        if (s == null || root == null) return false;

        return search(s, root);
    }

    private boolean search(String s, TreeNode node) {
        if (node == null) return false;

        if (node.val.equals(s)) return true;

        boolean left = false, right = false;

        if (s.compareTo(node.val) > 0) {
            right = search(s, node.right);
        } else {
            left = search(s, node.left);
        }

        return left || right;
    }

    @Override
    public int size() {
        return this.size;
    }

}
