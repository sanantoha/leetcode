package tree;

import java.util.LinkedList;
import java.util.Queue;

public class NodeDepths5 {

    // O(n) time | O(h) space
    public static int nodeDepths(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeInfo> queue = new LinkedList<>();
        queue.add(new TreeInfo(root, 0));

        int sumOfDepths = 0;

        while (!queue.isEmpty()) {
            TreeInfo ti = queue.remove();
            int depth = ti.depth;
            TreeNode curr = ti.node;

            if (curr == null) continue;

            sumOfDepths += depth;

            queue.add(new TreeInfo(curr.left, depth + 1));
            queue.add(new TreeInfo(curr.right, depth + 1));
        }

        return sumOfDepths;
    }

    static class TreeInfo {
        private TreeNode node;
        int depth;

        public TreeInfo(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    // O(n) time | O(h) space
    public static int nodeDepthsRec(TreeNode root) {
        return nodeDepthsRec(root, 0);
    }

    private static int nodeDepthsRec(TreeNode root, int depth) {
        if (root == null) return 0;

        return depth + nodeDepthsRec(root.left, depth + 1) + nodeDepthsRec(root.right, depth + 1);
    }

    /**
     *  Write function that takes in a Binary Tree and return the sum of its node's depths.
     *  https://www.algoexpert.io/questions/Node%20Depths
     *            1
     *          /   \
     *         2     3
     *       /  \  /  \
     *     4    5 6    7
     *   / \
     *  8   9
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(8),
                                new TreeNode(9)),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)));

        int val = nodeDepths(root);
        System.out.println(val);
        System.out.println(val == 16);
        val = nodeDepthsRec(root);
        System.out.println(val);
        System.out.println(val == 16);
    }
}