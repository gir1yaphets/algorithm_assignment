package ex1;

import java.util.LinkedList;
import java.util.Queue;

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
//            TreeNode node = new TreeNode(s);
//            node.left = root;
//            root = node;

            insertNode(s);
        }

        return true;
    }

    private void insertNode(String s) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null) {
                node.left = new TreeNode(s);
                return;
            } else if (node.right == null) {
                node.right = new TreeNode(s);
                return;
            } else {
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
    }

    @Override
    public boolean contains(String s) {
//        TreeNode curr = root;
//
//        while (curr != null) {
//            if (curr.val.equals(s)) {
//                return true;
//            }
//
//            curr = curr.left;
//        }
//        return false;
        if (s == null || root == null) return false;

        return search(s, root);
    }

    private boolean search(String s, TreeNode node) {
        if (node == null) return false;

        if (node.val.equals(s)) return true;

        return search(s, node.left) || search(s, node.right);
    }

    @Override
    public int size() {
        return this.size;
    }

}
